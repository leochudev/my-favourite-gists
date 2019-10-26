package com.leochudevelop.sharepublicgist.source

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A singleton class to provide the retrofit client to access to the GitHub server.
 */
object RetrofitClient {

    private const val API_URL = "https://api.github.com/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("User-Agent", "Share-Public-Gists")
                    .build()
                chain.proceed(request)
            }
        }.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()
    }

    val gitHubService: GitHubService by lazy {
        retrofit.create(GitHubService::class.java)
    }
}