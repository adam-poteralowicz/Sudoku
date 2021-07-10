package com.apap.sudoku.view.game.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apap.sudoku.R
import com.apap.sudoku.view.game.listener.SudokuDigitChangedListener

class SudokuRecyclerViewAdapter(private val array: Array<IntArray>, private val onSudokuCellClickListener: OnSudokuCellClickListener) : RecyclerView.Adapter<SudokuViewHolder>() {

    interface OnSudokuCellClickListener {
        fun onSudokuCellClick(sudokuDigit: TextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SudokuViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.sudoku_item, parent, false)
        return SudokuViewHolder(view, this.onSudokuCellClickListener)
    }

    override fun onBindViewHolder(holder: SudokuViewHolder, position: Int) {

        val x = position / 9
        val y = if (position == x * 9) 0 else position - (x * 9)

        if (array[x][y] > 0) {
            holder.mSudokuDigit?.typeface = Typeface.DEFAULT_BOLD
            holder.mSudokuDigit?.isEnabled = false
            holder.mSudokuDigit?.text = array[x][y].toString()
        } else if (array[x][y] == 0) {
            holder.mSudokuDigit!!.text = " "
        }

        holder.mSudokuDigit?.addTextChangedListener(SudokuDigitChangedListener(array, holder))
    }

    override fun getItemCount(): Int {
        return array.size * array[0].size
    }
}