package com.apap.sudoku.util

class Sudoku(private val puzzle: Array<IntArray>) {

    fun checkCorrectness(): Boolean =
        when {
            puzzle.isEmpty() || blanksRemaining() -> false
            checkRows() && checkColumns() && validateMatrix() -> true
            else -> false
        }

    private fun blanksRemaining(): Boolean {
        val blanks = (puzzle.indices).flatMap { row ->
            (puzzle[row].indices).filter { column ->
                puzzle[row][column] == 0
            }
        }

        return blanks.isNotEmpty()
    }

    private fun checkRows(): Boolean = puzzle.indices.all { row -> isSumCorrect(puzzle[row]) }

    private fun checkColumns(): Boolean {
        var column: IntArray

        for (i in puzzle.indices) {
            column = IntArray(puzzle.size)
            puzzle.indices.forEach { row ->
                column[row] = puzzle[row][i]
            }

            if (!isSumCorrect(column)) {
                return false
            }
        }

        return true
    }

    private fun validateMatrix(): Boolean {

        return validateSubMatrix(0, 2, 0, 2)
                && validateSubMatrix(3, 5, 0, 2)
                && validateSubMatrix(6, 8, 0, 2)
                && validateSubMatrix(0, 2, 3, 5)
                && validateSubMatrix(3, 5, 3, 5)
                && validateSubMatrix(6, 8, 3, 5)
                && validateSubMatrix(0, 2, 6, 8)
                && validateSubMatrix(3, 5, 6, 8)
                && validateSubMatrix(6, 8, 6, 8)
    }

    private fun validateSubMatrix(index1: Int, index2: Int, index3: Int, index4: Int): Boolean {

        val matrix = puzzle.sliceArray(index1..index2)
        val values = ArrayList<Int>()

        matrix.forEachIndexed { i, _ ->
            matrix[i].sliceArray(index3..index4).forEach {
                values.add(it)
            }
        }

        if (values.distinct().size < 9) {
            return false
        }

        return isSumCorrect(values)
    }

    private fun isSumCorrect(array: IntArray): Boolean {
        return array.reduce { acc, digit -> acc + digit } == 45
    }

    private fun isSumCorrect(list: ArrayList<Int>): Boolean {
        return list.distinct().reduce { acc, digit -> acc + digit } == 45
    }
}