package com.leochudevelop.myfavouritegists.data

/**
 * A DTO for [https://api.github.com/gists/public] API.
 */
data class GistDto(
    val id: String = "",
    val url: String = "",
    val files: Map<String, GistFile>,
    val owner: User
)

data class GistFile(val filename: String)

data class User(val login: String)