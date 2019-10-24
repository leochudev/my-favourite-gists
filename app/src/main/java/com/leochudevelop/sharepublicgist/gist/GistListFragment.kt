package com.leochudevelop.sharepublicgist.gist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.leochudevelop.sharepublicgist.R
import com.leochudevelop.sharepublicgist.utils.InjectorUtils
import kotlinx.android.synthetic.main.fragment_gist_list.view.*
import kotlinx.coroutines.launch

/**
 * A [Fragment] to display the public gists list.
 */
class GistListFragment: Fragment() {

    private lateinit var gistListAdapter: GistListAdapter
    private lateinit var gistRepository: GistRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_gist_list, container, false)

        gistListAdapter = GistListAdapter()
        root.gist_list.setHasFixedSize(true)
        root.gist_list.adapter = gistListAdapter

        gistRepository = InjectorUtils.getGistRepository()

        viewLifecycleOwner.lifecycleScope.launch {
            val dataSet = gistRepository.getAllGistIds()
            gistListAdapter.replaceAll(dataSet)
        }

        return root
    }
}