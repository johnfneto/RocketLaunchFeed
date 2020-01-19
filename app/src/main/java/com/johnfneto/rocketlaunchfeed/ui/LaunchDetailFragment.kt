package com.johnfneto.rocketlaunchfeed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.johnfneto.rocketlaunchfeed.LaunchesData.launchesList
import com.johnfneto.rocketlaunchfeed.R
import com.johnfneto.rocketlaunchfeed.databinding.LaunchDetailBinding
import com.johnfneto.rocketlaunchfeed.models.LaunchModel
import com.squareup.picasso.Picasso

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [LaunchListActivity]
 * in two-pane mode (on tablets) or a [LaunchDetailActivity]
 * on handsets.
 */
class LaunchDetailFragment : Fragment() {

    private lateinit var binding : LaunchDetailBinding
    private var item: LaunchModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                item = launchesList[it.getInt(ARG_ITEM_ID)]
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.launch_detail, container, false)

        item?.let {
            binding.launch = it
            Picasso.get().load(it.img_url).placeholder(R.drawable.ic_launcher_foreground).into(binding.ivLaunch)
        }

        return binding.root
    }

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }
}
