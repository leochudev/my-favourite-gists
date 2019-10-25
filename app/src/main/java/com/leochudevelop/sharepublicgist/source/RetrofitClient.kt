package com.leochudevelop.sharepublicgist.source

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A singleton class to provide the retrofit client to access to the GitHub server.
 */
object RetrofitClient {

    private const val API_URL = "https://api.github.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    val gitHubService: GitHubService by lazy {
        retrofit.create(GitHubService::class.java)
    }
}