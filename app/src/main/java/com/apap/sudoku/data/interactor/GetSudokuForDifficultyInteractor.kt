package com.apap.sudoku.data.interactor

import androidx.lifecycle.LiveData
import com.apap.sudoku.data.model.SudokuBoardResponse
import com.apap.sudoku.data.source.repository.SudokuRepositoryImpl
import javax.inject.Inject

class GetSudokuForDifficultyInteractor @Inject constructor(var sudokuRepository: SudokuRepositoryImpl) {

    fun getPuzzle(p: String): LiveData<SudokuBoardResponse> {
        return sudokuRepository.getSudoku(p)
    }
}