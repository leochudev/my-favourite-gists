package com.leochudevelop.sharepublicgist.utils

import androidx.lifecycle.ViewModelProvider
import com.leochudevelop.sharepublicgist.list.GistListViewModelFactory
import com.leochudevelop.sharepublicgist.source.GistRepository

object InjectorUtils {

    private fun getGistRepository(): GistRepository = GistRepository.getInstance()

    fun provideGistListViewModelFactory(): ViewModelProvider.Factory {
        val repository = getGistRepository()
        return GistListViewModelFactory(repository)
    }
}