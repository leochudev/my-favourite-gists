package com.leochudevelop.sharepublicgist.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.leochudevelop.sharepublicgist.data.Gist
import com.leochudevelop.sharepublicgist.source.GistRepository

class GistListViewModel internal constructor(gistRepository: GistRepository) : ViewModel() {
    val gists: LiveData<List<Gist>> = gistRepository.getGists()
}