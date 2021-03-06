package com.apap.sudoku.view.home.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.R
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.home.dialog.QuitConfirmationDialog
import kotlinx.android.synthetic.main.activity_welcome.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        sudoku_start_button.setOnClickListener { _ ->
            val sudokuIntent = Intent(this, SudokuActivity::class.java )
            startActivity(sudokuIntent)
        }
    }

    override fun onBackPressed() {
        showDialog(QuitConfirmationDialog.newInstance(), QuitConfirmationDialog.TAG)
    }

    private fun showDialog(fragment: DialogFragment, tag: String) {
        fragment.show(this@HomeActivity.supportFragmentManager, tag)
    }
}