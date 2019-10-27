package com.leochudevelop.myfavouritegists.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.leochudevelop.myfavouritegists.R
import com.leochudevelop.myfavouritegists.utils.InjectorUtils
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
        viewModel.gistId.value = args.gistId
        viewModel.username.value = args.username
        viewModel.favourite.value = args.favourite
        viewModel.url.value = args.url
        viewModel.shares.value = args.shares
        viewModel.filenames.value = args.filenames
    }

    private fun subscribeUI(root: View) {
        viewModel.let {
            it.gistId.observe(viewLifecycleOwner) { gistId ->
                root.id_text_view.text = gistId
            }
            it.username.observe(viewLifecycleOwner) { username ->
                root.owner_name_text_view.text = username
            }
            it.favourite.observe(viewLifecycleOwner) { favourite ->
                root.favourite_button.setFavouriteText(favourite)
            }
            it.filenames.observe(viewLifecycleOwner) { files ->
                root.filename_text_view.text = files
            }
            it.shares.observe(viewLifecycleOwner) { shares ->
                root.share_count_text_view.text = shares.toString()
            }
            it.url.observe(viewLifecycleOwner) { url ->
                root.url_text_view.text = url
            }
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
