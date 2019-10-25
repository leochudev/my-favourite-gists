package com.leochudevelop.sharepublicgist.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.leochudevelop.sharepublicgist.data.Gist
import com.leochudevelop.sharepublicgist.source.GistRepository

class GistListViewModel internal constructor(gistRepository: GistRepository) : ViewModel() {
    val gists: LiveData<Collection<Gist>> =
        liveData { emit(gistRepository.getGists()) }
}