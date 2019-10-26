package com.leochudevelop.sharepublicgist.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.leochudevelop.sharepublicgist.data.Gist
import com.leochudevelop.sharepublicgist.data.GistDao
import com.leochudevelop.sharepublicgist.data.GistDto
import com.leochudevelop.sharepublicgist.source.GitHubService
import com.leochudevelop.sharepublicgist.utils.InjectorUtils
import kotlinx.coroutines.coroutineScope

class GistDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val gitHubService: GitHubService by lazy {
        InjectorUtils.provideGistHubService()
    }
    private val gistDao: GistDao by lazy {
        InjectorUtils.provideGistDao(context)
    }

    override suspend fun doWork(): Result = coroutineScope {
        try {
            val gistDtoList = gitHubService.allPublicGists()
            val gists = gistDtoList.map { it.convertToGist() }
            gists.forEach { it.shareCount = gitHubService.userGists(it.username).size }

            gistDao.insertAll(gists)

            Result.success()
        } catch (exception: Exception) {
            Log.e(TAG, "Error creating database", exception)
            Result.failure()
        }
    }

    private fun GistDto.convertToGist(): Gist =
        Gist(id, url, files.keys.toString(), owner.login)

    companion object {
        private val TAG = GistDatabaseWorker::class.java.simpleName
    }
}