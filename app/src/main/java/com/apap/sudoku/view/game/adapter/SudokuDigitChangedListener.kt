package com.apap.sudoku.view.game.adapter

import android.text.Editable
import android.text.TextWatcher

class SudokuDigitChangedListener(
    private val puzzle: Array<IntArray>,
    private val holder: SudokuViewHolder
) : TextWatcher {

    override fun afterTextChanged(s: Editable?) {
        s?.let {
            val x = holder.adapterPosition / 9
            val y = if (holder.adapterPosition == x * 9) 0 else holder.adapterPosition - (x * 9)

            //println("Listener AFTER || new digit: ${s.trim()}")
            if (!s.toString().equals(" ") && !s.toString().equals("") && !s.trim().toString().equals("0")) {
                puzzle[x][y] = Integer.parseInt(holder.mSudokuDigit!!.text.trim().toString())
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //println("Listener BEFORE || new digit: ${s!!.trim()}")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //println("Listener ON || new digit: ${s!!.trim()}")
    }
}