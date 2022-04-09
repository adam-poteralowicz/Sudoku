package com.apap.sudoku

import android.os.Build
import com.apap.sudoku.databinding.ActivitySudokuBinding
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.game.dialog.SudokuDifficultyChoiceDialog
import com.apap.sudoku.view.game.dialog.SudokuDigitChoiceDialog
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class SudokuActivityTest {

    private lateinit var activity: SudokuActivity
    private lateinit var binding: ActivitySudokuBinding

    @Before
    fun setUp() {
        activity = Robolectric.setupActivity(SudokuActivity::class.java)
        binding = activity.binding
    }

    @Test
    fun shouldShowDifficultyChoiceDialogOnNewPuzzleClick() {
        binding.generatePuzzleButton.performClick()

        val expectedFragment = activity.supportFragmentManager.findFragmentByTag(SudokuDifficultyChoiceDialog.TAG)
        assertNotNull(expectedFragment)
    }

    @Test
    fun shouldShowDigitChoiceDialogOnSudokuCellClick() {
        val item = activity.binding.sudokuRecyclerView.findViewHolderForAdapterPosition(0)
        assertNotNull(item)
        assertNotNull(item!!.itemView)
        item.itemView.performClick()

        val expectedFragment = activity.supportFragmentManager.findFragmentByTag(SudokuDigitChoiceDialog.TAG)
        assertNotNull(expectedFragment)
    }
}