package com.johnfneto.rocketlaunchfeed

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.johnfneto.rocketlaunchfeed.ui.LaunchDetailActivity
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.core.Is.`is`
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LaunchDetailActivityTest {

    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test.
     */
    @Rule
    @JvmField
    var rule: ActivityTestRule<LaunchDetailActivity> = object : ActivityTestRule<LaunchDetailActivity>(
        LaunchDetailActivity::class.java
    ) {
        override fun getActivityIntent(): Intent {
            InstrumentationRegistry.getInstrumentation()
            val intent = Intent(Intent.ACTION_MAIN)
            intent.putExtra("item_id", 0)
            return intent
        }
    }


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
    fun ensureIntentDataIsDisplayed() {
        val activity: LaunchDetailActivity = rule.activity
        val viewById: View = activity.findViewById(R.id.tvName)
        assertThat(viewById, notNullValue())
        assertThat(viewById, instanceOf(TextView::class.java))
        val textView = viewById as TextView
        assertThat(textView.text.toString(), `is` ("Falcon 9 Block 5 | Dragon In-Flight Abort Test"))
    }
}
