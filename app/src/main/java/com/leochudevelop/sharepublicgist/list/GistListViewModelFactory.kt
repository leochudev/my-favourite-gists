package com.leochudevelop.sharepublicgist.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leochudevelop.sharepublicgist.source.GistRepository

/**
 * Factory for creating a [GistListViewModel] with a constructor that takes a [GistRepository].
 */
class GistListViewModelFactory(
    private val repository: GistRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = GistListViewModel(repository) as T
}
