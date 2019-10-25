package com.leochudevelop.sharepublicgist.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.leochudevelop.sharepublicgist.data.AppDatabase
import com.leochudevelop.sharepublicgist.data.Gist
import com.leochudevelop.sharepublicgist.utils.RetrofitClient
import kotlinx.coroutines.coroutineScope

class GistDatabaseWorker(
    context: Context, workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = coroutineScope {
        try {
            val gistDtoList = RetrofitClient.gitHubService.allPublicGists()
            val gists = gistDtoList.map {
                Gist(it.id, it.url, it.files.keys.toString(), it.owner.login)
            }
            val database = AppDatabase.getInstance(applicationContext)
            database.gistDao().insertAll(gists)

            Result.success()

        } catch (ex: Exception) {
            Log.e(TAG, "Error creating database", ex)
            Result.failure()
        }
    }

    companion object {
        private val TAG = GistDatabaseWorker::class.java.simpleName
    }
}