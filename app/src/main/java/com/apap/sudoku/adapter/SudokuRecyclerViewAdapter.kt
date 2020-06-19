package com.apap.sudoku.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apap.sudoku.R

class SudokuRecyclerViewAdapter(private val array: Array<IntArray>) :
    RecyclerView.Adapter<SudokuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SudokuViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.sudoku_item, parent, false)
        return SudokuViewHolder(view)
    }

    override fun onBindViewHolder(holder: SudokuViewHolder, position: Int) {

        val x = if (position / 9 == 0) 1 else position / 9 + 1
        val y = if (position == (x - 1) * 9) 1 else position - (x - 1) * 9 + 1

        if (array[x-1][y-1] > 0) {
            holder.mSudokuDigit!!.typeface = Typeface.DEFAULT_BOLD
            holder.mSudokuDigit!!.isEnabled = false
            holder.mSudokuDigit!!.text = array[x-1][y-1].toString()
        } else {
            holder.mSudokuDigit!!.text = " "
        }
    }

    override fun getItemCount(): Int {
        return array.size * array[0].size
    }
}