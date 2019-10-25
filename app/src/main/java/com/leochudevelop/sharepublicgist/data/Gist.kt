package com.leochudevelop.sharepublicgist.data

import com.google.gson.annotations.SerializedName

/**
 * A DTO for [https://api.github.com/gists/public] API.
 */
data class Gist(
    val id: String = "",
    val url: String = "",
    val files: Map<String, GistFile>,
    val owner: User
)

data class GistFile(val filename: String)

data class User(val login: String, @SerializedName("avatar_url") val avatarUrl: String)