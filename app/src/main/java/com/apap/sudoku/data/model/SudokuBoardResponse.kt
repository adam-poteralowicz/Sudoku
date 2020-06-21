package com.apap.sudoku.data.model

import com.google.gson.annotations.SerializedName

class SudokuBoardResponse {

    @SerializedName("board")
    val _board: Array<IntArray>? = null
}