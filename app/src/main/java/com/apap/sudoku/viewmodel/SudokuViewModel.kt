package com.apap.sudoku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apap.sudoku.data.interactor.GetSudokuForDifficultyInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SudokuViewModel @Inject constructor(private var getSudokuForDifficultyInteractor: GetSudokuForDifficultyInteractor) :
    ViewModel() {

    private val board: MutableLiveData<Array<IntArray>> by lazy {
        MutableLiveData<Array<IntArray>>() .also {
            fetchSudoku("easy")
        }
    }

    companion object {
        val disposable = CompositeDisposable()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getBoard() : LiveData<Array<IntArray>> {
        return board
    }

    private fun fetchSudoku(difficulty: String) {
        disposable.add(getSudokuForDifficultyInteractor.execute(difficulty).subscribe { it -> board.value = it._board})
    }
}
