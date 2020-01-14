package com.johnfneto.rocketlaunchfeed.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.johnfneto.rocketlaunchfeed.*
import com.johnfneto.rocketlaunchfeed.LaunchesData.launchesList
import com.johnfneto.rocketlaunchfeed.databinding.ActivityItemListBinding
import com.johnfneto.rocketlaunchfeed.models.ResultsModel
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [LaunchDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class LaunchListActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private val TAG = javaClass.simpleName

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false
    private lateinit var viewModel: LaunchViewModel
    private lateinit var binding: ActivityItemListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        binding.frameLayout.swipe_container.setOnRefreshListener(this)
        viewModel = ViewModelProviders.of(this).get(LaunchViewModel::class.java)

        if (launchesList.isEmpty()) {
            callServer()
        }

        if (binding.frameLayout.item_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        setupRecyclerView(item_list)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = LaunchAdapter(this, launchesList, twoPane)
    }

    private fun processResponse(launchModel: ResultsModel?) {
        binding.frameLayout.swipe_container.isRefreshing = false
        val results = launchModel?.results
        launchesList.clear()
        results?.let { launchesList.addAll(it) }
        item_list.adapter?.notifyDataSetChanged()
    }

    private fun callServer() {
        if (Utils.isInternetAvailable(this)) {
            binding.frameLayout.swipe_container.isRefreshing = true
            viewModel.getLaunches(object : OnDataCallback {
                override fun onSuccess(resultsModel: ResultsModel) {
                    processResponse(resultsModel)
                }

                override fun onError(error: String) {
                    binding.frameLayout.swipe_container.isRefreshing = false
                    Toast.makeText(
                        this@LaunchListActivity,
                        R.string.error_msg,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        } else {
            binding.frameLayout.swipe_container.isRefreshing = false
            Toast.makeText(
                this@LaunchListActivity,
                R.string.no_internet,
                Toast.LENGTH_LONG
            ).show()
        }
    }


    override fun onRefresh() {
        callServer()
    }
}
