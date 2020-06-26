package com.apap.sudoku

import android.content.Intent
import android.os.Build
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.home.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class HomeActivityTest {

    @Test
    fun shouldStartSudokuActivityOnStartGameClick() {

        val activity = Robolectric.setupActivity(HomeActivity::class.java)
        activity.sudoku_start_button.performClick()

        val expectedIntent = Intent(activity, SudokuActivity::class.java)
        val actualIntent = Shadows.shadowOf(RuntimeEnvironment.application).nextStartedActivity
        Assert.assertEquals(expectedIntent.component, actualIntent.component)
    }
}
