package com.leochudevelop.sharepublicgist.source

import com.leochudevelop.sharepublicgist.data.Gist
import com.leochudevelop.sharepublicgist.data.GistDao
import com.leochudevelop.sharepublicgist.data.GistDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A singleton repository class to provide the gists information.
 */
// TODO: use DI framework instead of singleton pattern.
class GistRepository private constructor(
    private val gistDao: GistDao,
    private val gitHubService: GitHubService
) {

    fun getGists() = gistDao.getGists()

    suspend fun updateFavourite(gistId: String, isFavourite: Boolean) =
        gistDao.updateFavourite(gistId, isFavourite)

    suspend fun fetchGistsFromServer() = withContext(Dispatchers.IO) {
        val gistDtoList = gitHubService.allPublicGists()
        val gists = gistDtoList.map { it.convertToGist() }
        gists.forEach { it.shareCount = gitHubService.userGists(it.username).size }
        gistDao.insertAll(gists)
    }

    private fun GistDto.convertToGist(): Gist =
        Gist(id, url, files.keys.toString(), owner.login)

    companion object {
        @Volatile
        private var instance: GistRepository? = null

        fun getInstance(gistDao: GistDao, gitHubService: GitHubService): GistRepository =
            instance ?: synchronized(this) {
                instance ?: GistRepository(gistDao, gitHubService).also { instance = it }
            }
    }
}