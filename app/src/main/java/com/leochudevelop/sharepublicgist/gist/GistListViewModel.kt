package com.leochudevelop.sharepublicgist.gist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class GistListViewModel internal constructor(gistRepository: GistRepository) : ViewModel() {
    val gists: LiveData<Collection<Gist>> =
        liveData { emit(gistRepository.getGists()) }
}