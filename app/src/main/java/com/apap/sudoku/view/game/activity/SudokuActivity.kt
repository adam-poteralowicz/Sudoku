package com.apap.sudoku.view.game.activity

import android.os.Bundle
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
import com.apap.sudoku.viewmodel.SudokuViewModel
import com.apap.sudoku.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_sudoku.*
import javax.inject.Inject

class SudokuActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var puzzle : Array<IntArray>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sudoku)

        observableViewModel()
    }

    private fun observableViewModel() {

        //val model = ViewModelProviders.of(this@SudokuActivity).get(SudokuViewModel::class.java)
        //val model = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(SudokuViewModel::class.java)
        val model : SudokuViewModel by viewModels() { viewModelFactory }
        model.getBoard().observe(this, Observer {
            puzzle = it

            val sudoku = Sudoku(puzzle!!)

            sudoku_recycler_view.apply {
                layoutManager = GridLayoutManager(this@SudokuActivity, 9)
                adapter = SudokuRecyclerViewAdapter(puzzle!!)
            }

            sudoku_recycler_view.adapter?.notifyDataSetChanged()

            check_puzzle_button.setOnClickListener { _ ->
                if (sudoku.checkCorrectness()) {
                    showDialog(PuzzleSolvedDialog.newInstance())
                } else {
                    showDialog(PuzzleNotSolvedDialog.newInstance())
                }
            }
        })
    }

    private fun showDialog(fragment: DialogFragment) {
        fragment.show(this@SudokuActivity.supportFragmentManager, fragment.tag)
    }
}