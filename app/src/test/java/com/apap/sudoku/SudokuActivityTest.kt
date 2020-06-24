package com.apap.sudoku

import android.os.Build
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.game.dialog.PuzzleNotSolvedDialog
import com.apap.sudoku.view.game.dialog.SudokuDifficultyChoiceDialog
import com.apap.sudoku.view.game.dialog.SudokuDigitChoiceDialog
import kotlinx.android.synthetic.main.activity_sudoku.*
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class SudokuActivityTest {

    @Test
    fun shouldShowDifficultyChoiceDialogOnNewPuzzleClick() {

        val activity = Robolectric.setupActivity(SudokuActivity::class.java)
        activity.generate_puzzle_button.performClick()

        val expectedFragment = activity.supportFragmentManager.findFragmentByTag(SudokuDifficultyChoiceDialog.TAG)
        assertNotNull(expectedFragment)
    }

    @Test
    fun shouldShowDigitChoiceDialogOnSudokuCellClick() {

        val activity = Robolectric.setupActivity(SudokuActivity::class.java)
        val item = activity.sudoku_recycler_view.findViewHolderForAdapterPosition(0)
        assertNotNull(item)
        assertNotNull(item!!.itemView)
        item.itemView.performClick()

        val expectedFragment = activity.supportFragmentManager.findFragmentByTag(SudokuDigitChoiceDialog.TAG)
        assertNotNull(expectedFragment)
    }

    @Test
    fun shouldShowPuzzleNotSolvedDialogOnCheckPuzzleClickWhenBoardHasBlanks() {

        val activity = Robolectric.setupActivity(SudokuActivity::class.java)
        activity.check_puzzle_button.performClick()

        val expectedFragment = activity.supportFragmentManager.findFragmentByTag(PuzzleNotSolvedDialog.TAG)
        assertNotNull(expectedFragment)
    }
}