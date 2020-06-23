package com.apap.sudoku.view.game.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.view.game.SudokuDigitOnClickListener

class SudokuDigitChoiceDialog(private val digit: TextView) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_digit_choice, container, true)

        val button1 = view.findViewById(R.id.digit1) as Button
        val button2 = view.findViewById(R.id.digit2) as Button
        val button3 = view.findViewById(R.id.digit3) as Button
        val button4 = view.findViewById(R.id.digit4) as Button
        val button5 = view.findViewById(R.id.digit5) as Button
        val button6 = view.findViewById(R.id.digit6) as Button
        val button7 = view.findViewById(R.id.digit7) as Button
        val button8 = view.findViewById(R.id.digit8) as Button
        val button9 = view.findViewById(R.id.digit9) as Button
        button1.setOnClickListener(SudokuDigitOnClickListener(digit))
        button2.setOnClickListener(SudokuDigitOnClickListener(digit))
        button3.setOnClickListener(SudokuDigitOnClickListener(digit))
        button4.setOnClickListener(SudokuDigitOnClickListener(digit))
        button5.setOnClickListener(SudokuDigitOnClickListener(digit))
        button6.setOnClickListener(SudokuDigitOnClickListener(digit))
        button7.setOnClickListener(SudokuDigitOnClickListener(digit))
        button8.setOnClickListener(SudokuDigitOnClickListener(digit))
        button9.setOnClickListener(SudokuDigitOnClickListener(digit))

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