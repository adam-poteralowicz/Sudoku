package com.apap.sudoku.view.home.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.apap.sudoku.databinding.HomeActivityBinding
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.home.dialog.QuitConfirmationDialog

class HomeActivity : AppCompatActivity() {

    lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sudokuStartButton.setOnClickListener {
            val sudokuIntent = Intent(this, SudokuActivity::class.java )
            startActivity(sudokuIntent)
        }
    }

    override fun onBackPressed() {
        showDialog(QuitConfirmationDialog.newInstance())
    }

    private fun showDialog(fragment: DialogFragment) {
        fragment.show(this@HomeActivity.supportFragmentManager, QuitConfirmationDialog.TAG)
    }
}