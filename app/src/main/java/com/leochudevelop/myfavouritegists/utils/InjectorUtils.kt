package com.leochudevelop.myfavouritegists.utils

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.leochudevelop.myfavouritegists.data.AppDatabase
import com.leochudevelop.myfavouritegists.data.GistDao
import com.leochudevelop.myfavouritegists.detail.GistDetailViewModelFactory
import com.leochudevelop.myfavouritegists.list.GistListViewModelFactory
import com.leochudevelop.myfavouritegists.source.GistRepository
import com.leochudevelop.myfavouritegists.source.GitHubService
import com.leochudevelop.myfavouritegists.source.RetrofitClient

object InjectorUtils {

    private fun getGistDao(context: Context): GistDao =
        AppDatabase.getInstance(context.applicationContext).gistDao()

    private fun getGistHubService(): GitHubService = RetrofitClient.gitHubService

    fun getGistRepository(context: Context): GistRepository =
        GistRepository.getInstance(getGistDao(context), getGistHubService())

    fun provideGistListViewModelFactory(context: Context): ViewModelProvider.Factory {
        val repository = getGistRepository(context)
        return GistListViewModelFactory(repository)
    }

    fun provideGistDetailViewModelFactory(
        context: Context
    ): ViewModelProvider.Factory {
        val repository = getGistRepository(context)
        return GistDetailViewModelFactory(repository)
    }
}