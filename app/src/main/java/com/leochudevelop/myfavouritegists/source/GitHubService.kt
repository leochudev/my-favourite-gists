package com.leochudevelop.myfavouritegists.source

import com.leochudevelop.myfavouritegists.data.GistDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * An interface of GitHub Rest API v3
 */
interface GitHubService {

    @GET("/gists/public")
    suspend fun allPublicGists(): List<GistDto>

    @GET("/users/{username}/gists")
    suspend fun userGists(@Path("username") username: String): List<GistDto>
}