package com.leochudevelop.myfavouritegists.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leochudevelop.myfavouritegists.source.GistRepository
import kotlinx.coroutines.launch

class GistDetailViewModel internal constructor(
    private val gistRepository: GistRepository
) : ViewModel() {

    val gistId: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val favourite: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val username: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val url: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val filenames: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val shares: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun toggleFavourite() {
        viewModelScope.launch {
            val isFavourite = !(favourite.value ?: false)
            gistRepository.updateFavourite(gistId.value ?: "", isFavourite)
            favourite.value = isFavourite
        }
    }
}