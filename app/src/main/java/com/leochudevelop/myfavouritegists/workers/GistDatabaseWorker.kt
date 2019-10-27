package com.leochudevelop.myfavouritegists.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.leochudevelop.myfavouritegists.source.GistRepository
import com.leochudevelop.myfavouritegists.utils.InjectorUtils
import kotlinx.coroutines.coroutineScope

class GistDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val gitRepository: GistRepository by lazy {
        InjectorUtils.getGistRepository(context)
    }

    override suspend fun doWork(): Result = coroutineScope {
        try {
            gitRepository.fetchGistsFromServer()
            Result.success()
        } catch (exception: Exception) {
            Log.e(TAG, "Error initiating database", exception)
            Result.failure()
        }
    }

    companion object {
        private val TAG = GistDatabaseWorker::class.java.simpleName
    }
}