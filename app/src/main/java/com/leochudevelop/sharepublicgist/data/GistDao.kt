package com.leochudevelop.sharepublicgist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GistDao {
    @Query("SELECT * FROM gists ORDER BY id")
    fun getGists(): LiveData<List<Gist>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Gist>)
}