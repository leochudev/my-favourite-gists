package com.leochudevelop.sharepublicgist.gist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leochudevelop.sharepublicgist.R

/**
 * A recycler view adapter to display the gist information.
 */
class GistListAdapter : RecyclerView.Adapter<GistListAdapter.MyViewHolder>() {

    private val dataSet: MutableList<String> = mutableListOf()

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.gist_item_view, parent, false) as TextView

        // TODO: set the view's size, margins, paddings and layout parameters

        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

    fun replaceAll(list: Collection<String>) {
        dataSet.clear()
        dataSet.addAll(list)
        notifyDataSetChanged()
    }
}