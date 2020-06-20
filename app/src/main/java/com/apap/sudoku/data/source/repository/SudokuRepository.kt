package com.apap.sudoku.data.source.repository

import com.apap.sudoku.data.model.SudokuBoardResponse
import io.reactivex.Observable

interface SudokuRepository {

    fun getSudoku(difficultyMode: String) : Observable<SudokuBoardResponse>
}