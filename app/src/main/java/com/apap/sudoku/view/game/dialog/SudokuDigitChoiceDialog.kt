package com.apap.sudoku.view.game.dialog

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.view.game.listener.SudokuDigitOnClickListener

class SudokuDigitChoiceDialog(private val digit: TextView) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_digit_choice, container, true)

        dialog!!.window!!.setGravity(Gravity.CENTER_HORIZONTAL)
        dialog!!.window!!.setGravity(Gravity.BOTTOM)

        (view.findViewById(R.id.digit1) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit2) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit3) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit4) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit5) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit6) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit7) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit8) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )
        (view.findViewById(R.id.digit9) as Button).setOnClickListener(
            SudokuDigitOnClickListener(
                digit
            )
        )

        return view
    }

    companion object {
        const val TAG = "CHOICE"

        @JvmStatic
        fun newInstance(digit: TextView) : SudokuDigitChoiceDialog {

            return SudokuDigitChoiceDialog(digit)
        }
    }
}