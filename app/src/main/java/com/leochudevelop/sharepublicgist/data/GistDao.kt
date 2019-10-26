package com.leochudevelop.sharepublicgist.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GistDao {
    @Query("SELECT * FROM gists ORDER BY id")
    fun getGists(): LiveData<List<Gist>>

    @Query("UPDATE Gists SET favourite = :favourite WHERE id = :gistId")
    suspend fun updateFavourite(gistId: String, favourite: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Gist>)
}