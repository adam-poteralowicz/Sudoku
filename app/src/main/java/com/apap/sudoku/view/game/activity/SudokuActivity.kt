package com.apap.sudoku.view.game.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.apap.sudoku.R
import com.apap.sudoku.Sudoku
import com.apap.sudoku.view.game.adapter.SudokuRecyclerViewAdapter
import com.apap.sudoku.view.game.dialog.PuzzleNotSolvedDialog
import com.apap.sudoku.view.game.dialog.PuzzleSolvedDialog
import com.apap.sudoku.view.game.dialog.SudokuDigitChoiceDialog
import com.apap.sudoku.viewmodel.SudokuViewModel
import com.apap.sudoku.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_sudoku.*
import javax.inject.Inject

class SudokuActivity : AppCompatActivity(), SudokuRecyclerViewAdapter.OnSudokuCellClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var sudoku : Sudoku
    lateinit var sudokuAdapter : SudokuRecyclerViewAdapter

    private var puzzle: Array<IntArray>? = arrayOf(
        IntArray(9), IntArray(9), IntArray(9),
        IntArray(9), IntArray(9), IntArray(9),
        IntArray(9), IntArray(9), IntArray(9)
    )

    companion object {

        fun changeDigit(digit: Int, cell: TextView) {
            cell.text = digit.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sudoku)
        AndroidInjection.inject(this@SudokuActivity)
        loadPuzzle()

        sudoku_recycler_view.apply {
            layoutManager = GridLayoutManager(this@SudokuActivity, 9)
            adapter = SudokuRecyclerViewAdapter(puzzle!!, this@SudokuActivity)
        }
        sudoku_recycler_view.adapter?.notifyDataSetChanged()

        check_puzzle_button.setOnClickListener {
            when (sudoku.checkCorrectness()) {
                true -> showDialog(PuzzleSolvedDialog.newInstance())
                false -> showDialog(PuzzleNotSolvedDialog.newInstance())
            }
        }

        generate_puzzle_button.setOnClickListener {
            loadPuzzle()
        }
    }

    override fun onSudokuCellClick(sudokuDigit: TextView) {
        if (sudokuDigit.isEnabled) {
            showDialog(SudokuDigitChoiceDialog.newInstance(sudokuDigit))
        }
    }

    private fun loadPuzzle() {

        val model: SudokuViewModel by viewModels() { viewModelFactory }

        model.getSudokuBoard().observe(this, Observer {
            puzzle = it.getBoard()
            sudoku_recycler_view.adapter = SudokuRecyclerViewAdapter(puzzle!!, this@SudokuActivity)
            sudoku = Sudoku(puzzle!!)
        })
    }

    private fun showDialog(fragment: DialogFragment) {
        fragment.show(this@SudokuActivity.supportFragmentManager, fragment.tag)
    }
}