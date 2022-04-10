package com.apap.sudoku.view.game.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apap.sudoku.R

class SudokuViewHolder(
    itemView: View,
    private val listener: SudokuRecyclerViewAdapter.OnSudokuCellClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var mSudokuDigit: TextView = itemView.findViewById(R.id.sudoku_digit)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) { itemView -> itemView.consumeOnCellEnabled(mSudokuDigit) }
    }

    private fun View.consumeOnCellEnabled(sudokuDigit: TextView) {
        if (this.isEnabled) listener.onSudokuCellClick(sudokuDigit)
    }
}