package com.apap.sudoku.view.game.listener

import android.text.Editable
import android.text.TextWatcher
import com.apap.sudoku.util.Board
import com.apap.sudoku.view.game.adapter.SudokuViewHolder

class SudokuDigitChangedListener(
    private val puzzle: Array<Board.Row>,
    private val holder: SudokuViewHolder
) : TextWatcher {

    override fun afterTextChanged(s: Editable?) {
        s ?: return

        val x = holder.adapterPosition / 9
        val y = if (holder.adapterPosition == x * 9) 0 else holder.adapterPosition - (x * 9)

        if (s.toString() != " " && s.toString() != "" && s.trim().toString() != "0") {
            puzzle[x][y] = Integer.parseInt(holder.mSudokuDigit.text?.trim().toString())
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
}