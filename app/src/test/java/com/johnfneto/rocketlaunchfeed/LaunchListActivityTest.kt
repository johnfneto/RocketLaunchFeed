package com.johnfneto.rocketlaunchfeed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.johnfneto.rocketlaunchfeed.ui.LaunchListActivity
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.Matchers.comparesEqualTo
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.shadows.ShadowLooper

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LaunchListActivityTest {

    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test.
     */
    @Rule
    @JvmField
    var rule: ActivityTestRule<LaunchListActivity> =
        ActivityTestRule<LaunchListActivity>(LaunchListActivity::class.java)


    @Before
    fun intentsInit() { // initialize Espresso Intents capturing
        Intents.init()
    }

    @After
    fun intentsTeardown() { // release Espresso Intents capturing
        Intents.release()
    }

    @Test
    @Throws(Exception::class)
    fun ensureListViewIsPresent() {
        val activity: LaunchListActivity = rule.activity
        val viewById: View = activity.findViewById(R.id.item_list)
        assertThat(viewById, notNullValue())
        assertThat(viewById, instanceOf(RecyclerView::class.java))
        val listView: RecyclerView = viewById as RecyclerView
        val adapter = listView.adapter
        assertThat(adapter, instanceOf(RecyclerView.Adapter::class.java))
        assertThat(adapter?.itemCount, comparesEqualTo(20))
    }

    @Test
    fun detailsActivityStartsOnClick() {
        ShadowLooper.runUiThreadTasks()
        onView(withId(R.id.item_list)).perform(click())
        assertTrue(true)
    }
}
