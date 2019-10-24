package com.leochudevelop.sharepublicgist.gist

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A singleton repository class to provide the gists information.
 */
// TODO: use DI framework instead of singleton pattern.
class GistRepository {

    private suspend fun getGists(): List<Gist> = withContext(Dispatchers.IO) {
        RetrofitClient.gitHubService.allPublicGists()
    }

    suspend fun getAllGistIds(): List<String> = withContext(Dispatchers.IO) {
        getGists().map { it.id }
    }

    companion object {
        @Volatile
        private var instance: GistRepository? = null

        fun getInstance(): GistRepository =
            instance ?: synchronized(this) {
                instance ?: GistRepository()
            }
    }
}