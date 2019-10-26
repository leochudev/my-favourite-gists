package com.leochudevelop.sharepublicgist.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leochudevelop.sharepublicgist.source.GistRepository
import kotlinx.coroutines.launch

class GistDetailViewModel internal constructor(
    private val gistRepository: GistRepository
) : ViewModel() {

    val favourite: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val username: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun toggleFavourite() {
        viewModelScope.launch {
            val isFavourite = !(favourite.value ?: false)
            gistRepository.updateFavourite(username.value ?: "", isFavourite)
            favourite.value = isFavourite
        }
    }
}