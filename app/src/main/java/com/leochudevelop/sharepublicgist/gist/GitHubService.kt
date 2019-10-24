package com.leochudevelop.sharepublicgist.gist

import retrofit2.http.GET

interface GitHubService {
    @GET("/gists/public")
    suspend fun allPublicGists(): List<Gist>
}