package com.apap.sudoku.view.game.dialog

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.apap.sudoku.R
import com.apap.sudoku.view.game.listener.SudokuDigitOnClickListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: ViewBinding
class SudokuDigitChoiceDialog(private val digit: TextView) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.digit_choice_dialog, container, true)

        dialog?.window?.setGravity(Gravity.CENTER_HORIZONTAL + Gravity.BOTTOM)

        (view.findViewById(R.id.digit1) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit2) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit3) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit4) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit5) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit6) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit7) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit8) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))
        (view.findViewById(R.id.digit9) as Button).setOnClickListener(SudokuDigitOnClickListener(digit, this))

        return view
    }

    companion object {
        const val TAG = "CHOICE"

        fun newInstance(digit: TextView) : SudokuDigitChoiceDialog {

            return SudokuDigitChoiceDialog(digit)
        }
    }
}