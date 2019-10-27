package com.leochudevelop.sharepublicgist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gists")
data class Gist(
    @PrimaryKey @ColumnInfo(name = "id") val gistId: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "files") val files: String,
    @ColumnInfo(name = "username") val username: String
) {
    @ColumnInfo(name = "favourite") var isFavourite: Boolean = false
    @ColumnInfo(name = "shares") var shareCount: Int = 0

    override fun toString() = gistId
}