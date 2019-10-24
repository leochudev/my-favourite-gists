package com.leochudevelop.sharepublicgist.utils

import com.leochudevelop.sharepublicgist.gist.GistRepository

object InjectorUtils {

    fun getGistRepository(): GistRepository = GistRepository.getInstance()
}