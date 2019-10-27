package com.leochudevelop.myfavouritegists.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.leochudevelop.myfavouritegists.data.Gist
import com.leochudevelop.myfavouritegists.source.GistRepository

class GistListViewModel internal constructor(
    gistRepository: GistRepository
) : ViewModel() {
    val gists: LiveData<List<Gist>> = gistRepository.getGists()
}