package com.apap.sudoku.adapter

import android.text.Editable
import android.text.TextWatcher

class SudokuDigitChangedListener(puzzle : Array<IntArray>, x: Int, y: Int) : TextWatcher {

    private val _puzzle = puzzle
    private val _x = x
    private val _y = y

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _puzzle[_x][_y] = if (s!!.toString().equals(" ")) return else Integer.parseInt(s.trim().toString())
    }
}