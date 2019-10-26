package com.leochudevelop.sharepublicgist.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.leochudevelop.sharepublicgist.R
import com.leochudevelop.sharepublicgist.utils.InjectorUtils
import kotlinx.android.synthetic.main.fragment_gist_detail.view.*

/**
 * A [Fragment] subclass to display the gist detail with specific gist id.
 */
class GistDetailFragment : Fragment() {

    private val args: GistDetailFragmentArgs by navArgs()

    private val viewModel: GistDetailViewModel by viewModels {
        InjectorUtils.provideGistDetailViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gist_detail, container, false)
        subscribeUI(root)
        updateUI()
        return root
    }

    private fun updateUI() {
        viewModel.username.value = args.username
        viewModel.favourite.value = args.favourite
    }

    private fun subscribeUI(root: View) {
        viewModel.favourite.observe(viewLifecycleOwner) { favourite ->
            root.favourite_button.setFavouriteText(favourite)
        }
        viewModel.username.observe(viewLifecycleOwner) {username ->
            root.id_text_view.text = username
        }
        root.favourite_button.setOnClickListener {
            viewModel.toggleFavourite()
        }
    }

    private fun Button.setFavouriteText(isFavourite: Boolean) {
        text = if (isFavourite) {
            getString(R.string.un_favourite)
        } else {
            getString(R.string.favourite)
        }
    }
}
