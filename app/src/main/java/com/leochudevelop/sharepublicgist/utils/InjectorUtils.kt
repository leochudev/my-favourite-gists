package com.leochudevelop.sharepublicgist.utils

import androidx.lifecycle.ViewModelProvider
import com.leochudevelop.sharepublicgist.gist.GistListViewModelFactory
import com.leochudevelop.sharepublicgist.gist.GistRepository

object InjectorUtils {

    private fun getGistRepository(): GistRepository = GistRepository.getInstance()

    fun provideGistListViewModelFactory(): ViewModelProvider.Factory {
        val repository = getGistRepository()
        return GistListViewModelFactory(repository)
    }
}