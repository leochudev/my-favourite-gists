package com.leochudevelop.sharepublicgist.source

import com.leochudevelop.sharepublicgist.data.GistDto
import retrofit2.http.GET

/**
 * An interface of GitHub Rest API v3
 */
interface GitHubService {
    @GET("/gists/public")
    suspend fun allPublicGists(): List<GistDto>
}