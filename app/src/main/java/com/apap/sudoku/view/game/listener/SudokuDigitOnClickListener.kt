package com.apap.sudoku.view.game.listener

import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.view.game.activity.SudokuActivity

// TODO: Use case ChangeDigit
open class SudokuDigitOnClickListener(
    private val textView: TextView,
    private val dialog: DialogFragment
) : View.OnClickListener {

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.digit1 -> SudokuActivity.changeDigit(1, textView)
            R.id.digit2 -> SudokuActivity.changeDigit(2, textView)
            R.id.digit3 -> SudokuActivity.changeDigit(3, textView)
            R.id.digit4 -> SudokuActivity.changeDigit(4, textView)
            R.id.digit5 -> SudokuActivity.changeDigit(5, textView)
            R.id.digit6 -> SudokuActivity.changeDigit(6, textView)
            R.id.digit7 -> SudokuActivity.changeDigit(7, textView)
            R.id.digit8 -> SudokuActivity.changeDigit(8, textView)
            R.id.digit9 -> SudokuActivity.changeDigit(9, textView)
        }

        dialog.dismiss()
    }
}