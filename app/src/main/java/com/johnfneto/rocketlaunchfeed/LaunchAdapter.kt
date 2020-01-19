package com.johnfneto.rocketlaunchfeed

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johnfneto.rocketlaunchfeed.databinding.LaunchItemBinding
import com.johnfneto.rocketlaunchfeed.models.LaunchModel
import com.johnfneto.rocketlaunchfeed.ui.LaunchDetailActivity
import com.johnfneto.rocketlaunchfeed.ui.LaunchDetailFragment
import com.johnfneto.rocketlaunchfeed.ui.LaunchListActivity
import com.squareup.picasso.Picasso

class LaunchAdapter(
    private val parentActivity: LaunchListActivity,
    private val launchesList: List<LaunchModel>?,
    private val twoPane: Boolean
)
    : RecyclerView.Adapter<LaunchAdapter.DataBindingViewHolder>() {
    private val TAG = javaClass.simpleName

    private lateinit var binding: LaunchItemBinding
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as Int
            if (twoPane) {
                val fragment = LaunchDetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(LaunchDetailFragment.ARG_ITEM_ID, item)
                    }
                }
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit()
            }
            else {
                val intent = Intent(v.context, LaunchDetailActivity::class.java).apply {
                    putExtra(LaunchDetailFragment.ARG_ITEM_ID, item)
                }
                v.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, R.layout.launch_item, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemCount() = launchesList!!.size

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        val item = launchesList!![position]
        holder.bind(item)
        with(holder.itemView) {
            tag = position
            setOnClickListener(onClickListener)
        }
    }

    inner class DataBindingViewHolder(private val binding: LaunchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LaunchModel) {
            binding.apply {
                launch = item

                ofInterest = item.pad!!.location!!.country_code == "RUS" || item.pad.location!!.country_code == "CHN" || item.pad.location.country_code == "UNK"
                if (!twoPane) {
                    if (!item.img_url.isNullOrEmpty()) {
                        Picasso.get().load(item.img_url)
                            .placeholder(R.drawable.ic_launcher_foreground).into(ivLaunch)
                    }
                }
            }
        }
    }
}