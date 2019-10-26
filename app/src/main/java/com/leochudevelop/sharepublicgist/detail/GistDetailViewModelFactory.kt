package com.leochudevelop.sharepublicgist.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leochudevelop.sharepublicgist.source.GistRepository

class GistDetailViewModelFactory(
    private val repository: GistRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = GistDetailViewModel(repository) as T
}