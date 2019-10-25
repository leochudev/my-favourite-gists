package com.leochudevelop.sharepublicgist.source

import com.leochudevelop.sharepublicgist.data.GistDao

/**
 * A singleton repository class to provide the gists information.
 */
// TODO: use DI framework instead of singleton pattern.
class GistRepository private constructor(private val gistDao: GistDao) {

    fun getGists() = gistDao.getGists()

    companion object {
        @Volatile
        private var instance: GistRepository? = null

        fun getInstance(gistDao: GistDao): GistRepository =
            instance ?: synchronized(this) {
                instance ?: GistRepository(gistDao).also { instance = it }
            }
    }
}