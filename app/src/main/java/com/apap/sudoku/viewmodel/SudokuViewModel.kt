package com.apap.sudoku.viewmodel

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apap.sudoku.data.interactor.GetSudokuForDifficultyInteractor
import com.apap.sudoku.data.model.SudokuBoardResponse
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SudokuViewModel @Inject constructor(private var getSudokuForDifficultyInteractor: GetSudokuForDifficultyInteractor) : ViewModel() {

    companion object {
        val disposable = CompositeDisposable()

        fun changeDigit(digit: Int, cell: TextView) {
            cell.text = digit.toString()
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getSudokuBoard() : LiveData<SudokuBoardResponse> {
        return fetchSudoku("easy")
    }

    private fun fetchSudoku(difficulty: String) : LiveData<SudokuBoardResponse> {
        return getSudokuForDifficultyInteractor.getPuzzle(difficulty)
    }
}
