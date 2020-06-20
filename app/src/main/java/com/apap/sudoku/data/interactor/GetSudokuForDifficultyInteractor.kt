package com.apap.sudoku.data.interactor

import com.apap.sudoku.base.BaseInteractor
import com.apap.sudoku.data.model.SudokuBoardResponse
import com.apap.sudoku.data.source.repository.SudokuRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetSudokuForDifficultyInteractor @Inject constructor(var sudokuRepository: SudokuRepository) : BaseInteractor<SudokuBoardResponse, String>() {

    override fun buildObservable(p: String): Observable<SudokuBoardResponse> {
        return sudokuRepository.getSudoku(p)
    }
}