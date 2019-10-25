package com.leochudevelop.sharepublicgist.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.leochudevelop.sharepublicgist.R
import com.leochudevelop.sharepublicgist.utils.InjectorUtils
import kotlinx.android.synthetic.main.fragment_gist_list.view.*

/**
 * A [Fragment] to display the public gists list.
 */
class GistListFragment : Fragment() {

    private val viewModel: GistListViewModel by viewModels {
        InjectorUtils.provideGistListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_gist_list, container, false)

        val gistListAdapter = GistListAdapter()
        root.gist_list.setHasFixedSize(true)
        root.gist_list.adapter = gistListAdapter

        subscribeUI(gistListAdapter)

        return root
    }

    private fun subscribeUI(adapter: GistListAdapter) {
        viewModel.gists.observe(viewLifecycleOwner) { gists ->
            adapter.submitList(gists)
        }
    }
}