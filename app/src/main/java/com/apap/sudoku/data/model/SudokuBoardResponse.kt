package com.apap.sudoku.data.model

import com.apap.sudoku.util.Board
import com.google.gson.annotations.SerializedName

class SudokuBoardResponse {

    @SerializedName("board")
    private lateinit var board: Array<Board.Row>

    fun getBoard() = board

    override fun toString() = board.map { element -> "${element.contentToString()}\n" }.toString()
}