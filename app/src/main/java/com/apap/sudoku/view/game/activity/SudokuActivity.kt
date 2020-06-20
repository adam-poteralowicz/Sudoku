package com.apap.sudoku.view.game.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.apap.sudoku.R
import com.apap.sudoku.Sudoku
import com.apap.sudoku.di.component.DaggerSudokuComponent
import com.apap.sudoku.di.module.RepositoryModule
import com.apap.sudoku.view.game.adapter.SudokuRecyclerViewAdapter
import com.apap.sudoku.view.game.dialog.PuzzleNotSolvedDialog
import com.apap.sudoku.view.game.dialog.PuzzleSolvedDialog
import kotlinx.android.synthetic.main.activity_sudoku.*

class SudokuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sudoku)

        setUpInjections()

        val puzzle = Sudoku.provideTestSudokuArray()
        val sudoku = Sudoku(puzzle)

        sudoku_recycler_view.apply {
            layoutManager = GridLayoutManager(this@SudokuActivity, 9)
            adapter = SudokuRecyclerViewAdapter(puzzle)
        }

        sudoku_recycler_view.adapter?.notifyDataSetChanged()

        check_puzzle_button.setOnClickListener { _ ->
            if (sudoku.checkCorrectness()) {
                showDialog(PuzzleSolvedDialog.newInstance())
            } else {
                showDialog(PuzzleNotSolvedDialog.newInstance())
            }
        }
    }

    private fun setUpInjections() {
        DaggerSudokuComponent
            .builder()
            .repositoryModule(RepositoryModule())
            .build()
            .inject(this@SudokuActivity)
    }

    private fun showDialog(fragment: DialogFragment) {
        fragment.show(this@SudokuActivity.supportFragmentManager, fragment.tag)
    }
}