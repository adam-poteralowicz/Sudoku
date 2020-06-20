package com.apap.sudoku.adapter

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.apap.sudoku.R

class SudokuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mSudokuDigit: EditText? = null
    var mSudokuCell: ImageView? = null

    init {
        mSudokuDigit = itemView.findViewById(R.id.sudoku_digit)
        mSudokuCell = itemView.findViewById(R.id.sudoku_cell)
    }
}