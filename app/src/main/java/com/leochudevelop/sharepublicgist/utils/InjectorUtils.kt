package com.leochudevelop.sharepublicgist.utils

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.leochudevelop.sharepublicgist.data.AppDatabase
import com.leochudevelop.sharepublicgist.list.GistListViewModelFactory
import com.leochudevelop.sharepublicgist.source.GistRepository

object InjectorUtils {

    private fun getGistRepository(context: Context): GistRepository =
        GistRepository.getInstance(AppDatabase.getInstance(context.applicationContext).gistDao())

    fun provideGistListViewModelFactory(context: Context): ViewModelProvider.Factory {
        val repository = getGistRepository(context)
        return GistListViewModelFactory(repository)
    }
}