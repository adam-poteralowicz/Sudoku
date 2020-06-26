package com.apap.sudoku

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.apap.sudoku.view.home.activity.HomeActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityInstrumentedTest {

    @Rule @JvmField
    val activityRule : ActivityTestRule<HomeActivity> = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun shouldDismissDialogOnBackPressedAndDialogCancellation() {

        onView(withId(R.id.sudoku_logo)).perform(ViewActions.pressBack())
        onView(withText(R.string.quit_app_question)).check(matches(isDisplayed()))
        onView(withText(R.string.dialog_cancel)).inRoot(RootMatchers.isDialog()).perform(click())

        Assert.assertFalse(activityRule.activity.isFinishing)
        onView(withId(R.id.sudoku_logo)).check(matches(isDisplayed()))
    }
}