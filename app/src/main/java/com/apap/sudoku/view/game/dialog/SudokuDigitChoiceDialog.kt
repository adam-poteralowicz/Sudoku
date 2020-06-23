package com.apap.sudoku.view.game.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R

class SudokuDigitChoiceDialog : DialogFragment() {

    var dialog : AlertDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        activity?.let {
            dialog = AlertDialog.Builder(it)
                .setView(R.layout.dialog_digit_choice)
                .create()
        }
        return dialog!!
    }

    companion object {
        const val TAG = "CHOICE"

        @JvmStatic
        fun newInstance() : SudokuDigitChoiceDialog {
            return SudokuDigitChoiceDialog()
        }
    }
}