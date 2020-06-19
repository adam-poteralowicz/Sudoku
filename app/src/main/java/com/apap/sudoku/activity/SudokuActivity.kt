package com.apap.sudoku.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.apap.sudoku.R
import com.apap.sudoku.Sudoku
import com.apap.sudoku.adapter.SudokuRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_sudoku.*

class SudokuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sudoku)

        sudoku_recycler_view.apply {
            layoutManager = GridLayoutManager(this@SudokuActivity, 9)
            adapter = SudokuRecyclerViewAdapter(Sudoku.provideTestSudokuArray())
        }
    }
}