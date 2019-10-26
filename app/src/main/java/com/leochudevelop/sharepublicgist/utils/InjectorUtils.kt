package com.leochudevelop.sharepublicgist.utils

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.leochudevelop.sharepublicgist.data.AppDatabase
import com.leochudevelop.sharepublicgist.data.GistDao
import com.leochudevelop.sharepublicgist.detail.GistDetailViewModelFactory
import com.leochudevelop.sharepublicgist.list.GistListViewModelFactory
import com.leochudevelop.sharepublicgist.source.GistRepository
import com.leochudevelop.sharepublicgist.source.GitHubService
import com.leochudevelop.sharepublicgist.source.RetrofitClient

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