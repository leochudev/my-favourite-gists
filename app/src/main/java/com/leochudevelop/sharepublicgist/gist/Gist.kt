package com.leochudevelop.sharepublicgist.gist

/**
 * A DTO for [https://api.github.com/gists/public] API.
 */
data class Gist(
    val id: String = "",
    val url: String = ""
)