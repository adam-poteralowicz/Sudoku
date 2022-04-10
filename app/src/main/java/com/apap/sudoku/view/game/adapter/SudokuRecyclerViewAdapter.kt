package com.apap.sudoku.view.game.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apap.sudoku.R
import com.apap.sudoku.util.Board
import com.apap.sudoku.view.game.listener.SudokuDigitChangedListener

class SudokuRecyclerViewAdapter(
    private val array: Array<Board.Row>,
    private val onSudokuCellClickListener: OnSudokuCellClickListener
) : RecyclerView.Adapter<SudokuViewHolder>() {

    interface OnSudokuCellClickListener {
        fun onSudokuCellClick(sudokuDigit: TextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SudokuViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.sudoku_cell, parent, false)
        return SudokuViewHolder(view, onSudokuCellClickListener)
    }

    override fun onBindViewHolder(holder: SudokuViewHolder, position: Int) {

        val x = position / 9
        val y = if (position == x * 9) 0 else position - (x * 9)

        with(holder.mSudokuDigit) {
            when {
                array[x][y] > 0 -> apply {
                    typeface = Typeface.DEFAULT_BOLD
                    isEnabled = false
                    text = array[x].toString()
                }
                array[x][y] == 0 -> text = " "
                else -> Unit
            }

            addTextChangedListener(SudokuDigitChangedListener(array, holder))
        }
    }

    override fun getItemCount() = array.size * array[0].size
}