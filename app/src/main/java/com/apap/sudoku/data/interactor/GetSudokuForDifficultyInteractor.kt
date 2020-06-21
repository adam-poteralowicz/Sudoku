package com.apap.sudoku.data.interactor

import com.apap.sudoku.base.BaseInteractor
import com.apap.sudoku.data.model.SudokuBoardResponse
import com.apap.sudoku.data.source.repository.SudokuRepositoryImpl
import io.reactivex.Observable
import javax.inject.Inject

class GetSudokuForDifficultyInteractor @Inject constructor(var sudokuRepository: SudokuRepositoryImpl) : BaseInteractor<SudokuBoardResponse, String>() {

    override fun buildObservable(p: String): Observable<SudokuBoardResponse> {
        return sudokuRepository.getSudoku(p)
    }
}