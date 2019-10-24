package com.leochudevelop.sharepublicgist.gist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.leochudevelop.sharepublicgist.R
import kotlinx.android.synthetic.main.fragment_gist_detail.view.*

/**
 * A [Fragment] subclass to display the gist detail with specific gist id.
 */
class GistDetailFragment : Fragment() {

    private val args: GistDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gist_detail, container, false)
        root.id_text_view.text = args.username
        return root
    }
}
