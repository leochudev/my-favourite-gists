package com.leochudevelop.sharepublicgist.gist

import retrofit2.http.GET

/**
 * An interface of GitHub Rest API v3
 */
interface GitHubService {
    @GET("/gists/public")
    suspend fun allPublicGists(): List<Gist>
}