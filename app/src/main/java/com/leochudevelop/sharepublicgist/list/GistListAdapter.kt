package com.leochudevelop.sharepublicgist.list

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leochudevelop.sharepublicgist.R
import com.leochudevelop.sharepublicgist.data.Gist
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
        private var actionId: String? = null

        init {
            root.setOnClickListener { it.navigateToDetail() }
        }

        fun bind(id: String, url: String, filename: String) {
            idTextView.text = resources.getString(R.string.id_text_format, id)
            urlTextView.text = resources.getString(R.string.url_text_format, url)
            filenameTextView.text = resources.getString(R.string.filename_text_format, filename)
            actionId = id
        }

        private fun View.navigateToDetail() {
            val directions =
                GistListFragmentDirections.actionGistListFragmentToGistDetailFragment(
                    actionId ?: ""
                )
            findNavController().navigate(directions)
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
        holder.bind(
            gist.id,
            gist.url,
            gist.files.keys.toString()
        )
    }
}

private class GistDiffCallback : DiffUtil.ItemCallback<Gist>() {

    override fun areItemsTheSame(oldItem: Gist, newItem: Gist): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Gist, newItem: Gist): Boolean {
        return oldItem == newItem
    }
}