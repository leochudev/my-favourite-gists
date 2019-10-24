package com.leochudevelop.sharepublicgist.gist

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GistRepository {

    private suspend fun getGists(): List<Gist> = withContext(Dispatchers.IO) {
        RetrofitClient.gitHubService.allPublicGists()
    }

    suspend fun getAllGistIds(): List<String> = withContext(Dispatchers.IO) {
        getGists().map { it.id }
    }
}