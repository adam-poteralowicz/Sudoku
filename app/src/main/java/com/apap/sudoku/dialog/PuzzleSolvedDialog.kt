package com.apap.sudoku.dialog

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.activity.SudokuActivity
import com.apap.sudoku.activity.WelcomeActivity

class PuzzleSolvedDialog : DialogFragment() {

    var dialog : AlertDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        activity?.let {
            dialog = AlertDialog.Builder(it)
                .setTitle(R.string.puzzle_solved_dialog_title)
                .setMessage(R.string.puzzle_solved_question)
                .setPositiveButton(R.string.dialog_ok) { _, _ ->
                    startActivity(Intent(it, SudokuActivity::class.java))
                }
                .setNegativeButton(getString(R.string.dialog_cancel)) { _, _ ->
                    startActivity(Intent(it, WelcomeActivity::class.java))
                }.create()
        }
        return dialog!!
    }

    companion object {
        const val TAG = "SOLVED"

        @JvmStatic
        fun newInstance() : PuzzleSolvedDialog {
            return PuzzleSolvedDialog()
        }
    }
}