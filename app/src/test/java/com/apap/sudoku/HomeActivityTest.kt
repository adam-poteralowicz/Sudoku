package com.apap.sudoku

import android.content.Intent
import android.os.Build
import com.apap.sudoku.databinding.ActivityWelcomeBinding
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.home.activity.HomeActivity
import org.junit.Assert
import org.junit.Before
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

    private lateinit var activity: HomeActivity
    private lateinit var binding: ActivityWelcomeBinding

    @Before
    fun setUp() {
        activity = Robolectric.setupActivity(HomeActivity::class.java)
        binding = activity.binding
    }

    @Test
    fun shouldStartSudokuActivityOnStartGameClick() {
        binding.sudokuStartButton.performClick()

        val expectedIntent = Intent(activity, SudokuActivity::class.java)
        val actualIntent = Shadows.shadowOf(RuntimeEnvironment.application).nextStartedActivity
        Assert.assertEquals(expectedIntent.component, actualIntent.component)
    }
}
