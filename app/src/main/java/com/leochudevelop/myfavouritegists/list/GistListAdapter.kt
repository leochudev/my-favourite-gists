package com.leochudevelop.myfavouritegists.list

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leochudevelop.myfavouritegists.Constant
import com.leochudevelop.myfavouritegists.R
import com.leochudevelop.myfavouritegists.data.Gist
import kotlinx.android.synthetic.main.gist_item_view.view.*

/**
 * A recycler view adapter to display the gist information.
 */
class GistListAdapter : ListAdapter<Gist, GistListAdapter.MyViewHolder>(GistDiffCallback()) {

    class MyViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        private val resources: Resources = root.context.resources
        private val idTextView: TextView = root.id_text_view
        private val urlTextView: TextView = root.url_text_view
        private val filenameTextView: TextView = root.filename_text_view
        private val userSharesTextView: TextView = root.user_shares_text_view
        private val starCheckBox: CheckBox = root.star_check_box

        private var gist: Gist? = null

        init {
            root.setOnClickListener { it.navigateToDetail() }
        }

        fun bind(gist: Gist) {
            this.gist = gist
            idTextView.text = resources.getString(R.string.id_text_format, gist.gistId)
            urlTextView.text = resources.getString(R.string.url_text_format, gist.url)
            filenameTextView.text = resources.getString(R.string.filename_text_format, gist.files)
            starCheckBox.isEnabled = gist.isFavourite

            if (gist.shareCount > Constant.MIN_GISTS_SHARE) {
                userSharesTextView.text =
                    resources.getString(
                        R.string.user_shares_text_format,
                        gist.username,
                        gist.shareCount
                    )
            } else {
                userSharesTextView.isVisible = false
            }
        }

        private fun View.navigateToDetail() {
            gist?.let {
                val directions =
                    GistListFragmentDirections.actionGistListFragmentToGistDetailFragment(
                        it.gistId, it.username, it.files, it.url, it.shareCount, it.isFavourite
                    )
                findNavController().navigate(directions)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val gistItemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.gist_item_view, parent, false)

        // TODO: set the view's size, margins, paddings and layout parameters

        return MyViewHolder(gistItemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val gist = getItem(position)
        holder.bind(gist)
    }
}

private class GistDiffCallback : DiffUtil.ItemCallback<Gist>() {

    override fun areItemsTheSame(oldItem: Gist, newItem: Gist): Boolean {
        return oldItem.gistId == newItem.gistId &&
                oldItem.isFavourite == newItem.isFavourite &&
                oldItem.shareCount == newItem.shareCount
    }

    override fun areContentsTheSame(oldItem: Gist, newItem: Gist): Boolean {
        return oldItem == newItem
    }
}