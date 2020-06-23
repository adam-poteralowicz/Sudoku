package com.apap.sudoku.view.game.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R

class PuzzleNotSolvedDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var dialog : AlertDialog? = null

        activity?.let {
            dialog = AlertDialog.Builder(it)
                .setTitle(getString(R.string.puzzle_not_solved_dialog_title))
                .setPositiveButton(R.string.puzzle_not_solved_dialog_ok) { dialog, _ ->
                    dialog.cancel()
                }.create()
        }

        return dialog!!
    }

    companion object {
        const val TAG = "NOT_SOLVED"

        @JvmStatic
        fun newInstance() : PuzzleNotSolvedDialog {
            return PuzzleNotSolvedDialog()
        }
    }
}