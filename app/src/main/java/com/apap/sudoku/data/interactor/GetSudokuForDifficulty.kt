package com.apap.sudoku.data.interactor

import androidx.lifecycle.LiveData
import com.apap.sudoku.data.model.SudokuBoardResponse
import com.apap.sudoku.data.source.repository.SudokuRepositoryImpl
import javax.inject.Inject

class GetSudokuForDifficulty @Inject constructor(var sudokuRepository: SudokuRepositoryImpl) {

    operator fun invoke(difficulty: String): LiveData<SudokuBoardResponse> {
        return sudokuRepository.getSudoku(difficulty)
    }
}