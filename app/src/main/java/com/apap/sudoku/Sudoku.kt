package com.apap.sudoku

class Sudoku(private val puzzle: Array<IntArray>) {

    companion object {

        fun provideTestSudokuArray() = arrayOf(
            intArrayOf(0, 0, 6, 0, 0, 0, 0, 0, 5),
            intArrayOf(1, 0, 0, 4, 5, 0, 0, 0, 0),
            intArrayOf(0, 5, 7, 0, 8, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 6, 5, 0, 0, 0),
            intArrayOf(3, 6, 5, 0, 9, 7, 4, 1, 2),
            intArrayOf(0, 8, 9, 0, 2, 4, 5, 6, 0),
            intArrayOf(0, 3, 0, 6, 4, 0, 9, 0, 8),
            intArrayOf(0, 0, 0, 0, 0, 8, 0, 0, 1),
            intArrayOf(9, 0, 0, 0, 1, 3, 6, 0, 0))
    }

    fun checkCorrectness() : Boolean = if (blanksRemaining() > 0) false else checkCorrectnessForRows().and(checkCorrectnessForColumns())

    private fun blanksRemaining(): Int {
        val blanks = (puzzle.indices).flatMap { row ->
            (puzzle[row].indices)
                .filter { column -> puzzle[row][column] == 0 }
        }

        return blanks.size
    }

    private fun checkCorrectnessForRows(): Boolean {
        var correctness = false

        puzzle.indices.forEach { row ->
            correctness = isSumCorrect(puzzle[row])
            if (!correctness) {
                return false
            }
        }

        return correctness
    }

    private fun checkCorrectnessForColumns() : Boolean {

        var correctness = false
        var column : IntArray

        for (i in puzzle.indices) {
            column = IntArray(puzzle.size)
            var j = 0
            puzzle.indices.forEach { row ->
                column[j] = puzzle[i][row]
                j++
            }

            correctness = isSumCorrect(column)
            if (!correctness) {
                return false
            }
        }

        return correctness
    }

    private fun isSumCorrect(array: IntArray): Boolean {
        return array.reduce { acc, digit -> acc + digit } == 45
    }
}