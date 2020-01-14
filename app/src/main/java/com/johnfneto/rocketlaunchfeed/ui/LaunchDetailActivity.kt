package com.johnfneto.rocketlaunchfeed.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.johnfneto.rocketlaunchfeed.R
import kotlinx.android.synthetic.main.activity_item_detail.*

class LaunchDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            val fragment = LaunchDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(LaunchDetailFragment.ARG_ITEM_ID,
                        intent.getIntExtra(LaunchDetailFragment.ARG_ITEM_ID, 0))
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }
}
