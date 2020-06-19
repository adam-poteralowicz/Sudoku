package com.apap.sudoku.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.apap.sudoku.R
import com.apap.sudoku.adapter.SudokuRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_sudoku.*

class SudokuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sudoku)

        val sudokuArray = arrayOf(
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 0, 0),
            intArrayOf(2, 0, 0, 0, 0, 0, 0, 7, 0),
            intArrayOf(0, 7, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 0, 0, 4, 0, 6, 0, 0, 7),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 2, 5, 4, 6),
            intArrayOf(3, 0, 2, 7, 6, 0, 9, 8, 0),
            intArrayOf(0, 6, 4, 9, 0, 3, 0, 0, 1),
            intArrayOf(9, 8, 0, 5, 2, 1, 0, 6, 0)
        )

        sudoku_recycler_view.apply {
            layoutManager = GridLayoutManager(this@SudokuActivity, 9)
            adapter = SudokuRecyclerViewAdapter(sudokuArray)
        }
    }
}