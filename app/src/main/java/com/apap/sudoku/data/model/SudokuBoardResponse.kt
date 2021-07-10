package com.apap.sudoku.data.model

import com.google.gson.annotations.SerializedName

class SudokuBoardResponse {

    @SerializedName("board")
    private val _board: Array<IntArray>? = null

    fun getBoard(): Array<IntArray> {
        return _board ?: emptyArray()
    }

    override fun toString(): String {
        return _board?.map { element ->
            "${element.contentToString()}\n"
        }.toString()
    }
}