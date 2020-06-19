package com.apap.sudoku.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apap.sudoku.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        sudoku_start_button.setOnClickListener { _ ->
            val sudokuIntent = Intent(this, SudokuActivity::class.java )
            startActivity(sudokuIntent)
        }
    }
}