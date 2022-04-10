package com.apap.sudoku.viewmodel

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apap.sudoku.data.interactor.GetSudokuForDifficulty
import com.apap.sudoku.data.model.SudokuBoardResponse
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SudokuViewModel @Inject constructor(
    private var getSudokuForDifficulty: GetSudokuForDifficulty
) : ViewModel() {

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

    // TODO: Is it the proper use of LiveData?
    fun getSudokuBoard(difficulty: String): LiveData<SudokuBoardResponse> {
        return fetchSudoku(difficulty)
    }

    private fun fetchSudoku(difficulty: String): LiveData<SudokuBoardResponse> {
        return getSudokuForDifficulty(difficulty)
    }
}
