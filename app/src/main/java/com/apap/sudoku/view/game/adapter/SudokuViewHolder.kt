package com.apap.sudoku.view.game.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apap.sudoku.R

class SudokuViewHolder(itemView: View, onSudokuCellClickListener: SudokuRecyclerViewAdapter.OnSudokuCellClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var mSudokuDigit: TextView? = null
    var mSudokuCell: ImageView? = null
    var onSudokuCellClickListener : SudokuRecyclerViewAdapter.OnSudokuCellClickListener

    init {
        mSudokuDigit = itemView.findViewById(R.id.sudoku_digit)
        mSudokuCell = itemView.findViewById(R.id.sudoku_cell)

        this.onSudokuCellClickListener = onSudokuCellClickListener
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            itemView -> if (itemView.isEnabled) onSudokuCellClickListener.onSudokuCellClick(mSudokuDigit!!)
        }
    }
}