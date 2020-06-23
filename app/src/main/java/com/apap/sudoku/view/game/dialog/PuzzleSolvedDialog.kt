package com.apap.sudoku.view.game.dialog

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.home.HomeActivity

class PuzzleSolvedDialog : DialogFragment() {

    var dialog : AlertDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        activity?.let {
            dialog = AlertDialog.Builder(it)
                .setTitle(R.string.puzzle_solved_dialog_title)
                .setMessage(R.string.puzzle_solved_question)
                .setPositiveButton(R.string.puzzle_solved_dialog_ok) { _, _ ->
                    startActivity(Intent(it, SudokuActivity::class.java))
                }
                .setNegativeButton(getString(R.string.dialog_cancel)) { _, _ ->
                    startActivity(Intent(it, HomeActivity::class.java))
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