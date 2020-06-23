package com.apap.sudoku.view.game.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.view.game.activity.SudokuActivity

class SudokuDifficultyChoiceDialog : DialogFragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.difficulty_choice_dialog, container, true)

        (view.findViewById(R.id.easy_mode) as Button).setOnClickListener(this)
        (view.findViewById(R.id.medium_mode) as Button).setOnClickListener(this)
        (view.findViewById(R.id.hard_mode) as Button).setOnClickListener(this)
        (view.findViewById(R.id.random_mode) as Button).setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.easy_mode -> (activity as SudokuActivity).loadPuzzle("easy")
            R.id.medium_mode -> (activity as SudokuActivity).loadPuzzle("medium")
            R.id.hard_mode -> (activity as SudokuActivity).loadPuzzle("hard")
            R.id.random_mode -> (activity as SudokuActivity).loadPuzzle("random")
        }

        dismiss()
    }

    companion object {
        const val TAG = "DIFFICULTY"

        @JvmStatic
        fun newInstance() : SudokuDifficultyChoiceDialog {

            return SudokuDifficultyChoiceDialog()
        }
    }
}