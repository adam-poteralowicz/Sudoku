package com.apap.sudoku.data.model

import com.google.gson.annotations.SerializedName

class SudokuBoardResponse {

    @SerializedName("board")
    private val _board: Array<IntArray>? = null

    fun getBoard() : Array<IntArray> {
        return _board!!
    }

    override fun toString(): String {

        var values = ""
        for (element in _board!!) {
            element.iterator().forEach {
                values = values.plus(it)
            }
            values = values.plus(" ")
        }

        return values
    }
}