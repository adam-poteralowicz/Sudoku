package com.apap.sudoku.util

class Sudoku(private val puzzle: Array<Board.Row>) {

    fun validate(): Boolean = when {
        puzzle.isEmpty() || areBlanksPresent() -> false
        checkRows() && checkColumns() && validateMatrix() -> true
        else -> false
    }

    private fun areBlanksPresent() = puzzle.filterBlanks().isNotEmpty()

    private fun Array<Board.Row>.filterBlanks() = this.indices.flatMap { row ->
        this[row].indices.filter { column ->
            this[row][column] == 0
        }
    }

    private fun checkRows(): Boolean = puzzle.indices.all { row -> isSumCorrect(puzzle[row]) }

    private fun checkColumns(): Boolean {
        var column: IntArray

        for (i in puzzle.indices) {
            column = Board.Row(puzzle.size).get()
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

    private fun isSumCorrect(array: IntArray) = array.reduce { acc, digit -> acc + digit } == 45
    private fun isSumCorrect(array: Board.Row) = isSumCorrect(array.get())
    private fun isSumCorrect(list: ArrayList<Int>) =
        list.distinct().reduce { acc, digit -> acc + digit } == 45
}