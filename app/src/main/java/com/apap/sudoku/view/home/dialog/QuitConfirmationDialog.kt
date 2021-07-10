package com.apap.sudoku.view.home.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.view.home.activity.HomeActivity
import kotlin.system.exitProcess

class QuitConfirmationDialog : DialogFragment() {

    var dialog : AlertDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        activity?.let {
            dialog = AlertDialog.Builder(it)
                .setTitle(getString(R.string.quit_app_question))
                .setPositiveButton(R.string.dialog_confirm) { _, _ ->
                    (activity as HomeActivity).finish()
                    exitProcess(0)
                }
                .setNegativeButton(getString(R.string.dialog_cancel)) { _, _ ->
                    dismiss()
                }.create()
        }
        return dialog!!
    }

    companion object {
        const val TAG = "QUIT"

        fun newInstance() : QuitConfirmationDialog {
            return QuitConfirmationDialog()
        }
    }
}