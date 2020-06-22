package com.apap.sudoku.data.source.repository

import androidx.lifecycle.MutableLiveData
import com.apap.sudoku.data.model.SudokuBoardResponse

interface SudokuRepository {

    fun getSudoku(difficultyMode: String) : MutableLiveData<SudokuBoardResponse>
}