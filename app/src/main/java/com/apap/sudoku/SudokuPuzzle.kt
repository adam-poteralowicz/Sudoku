package com.apap.sudoku

class Sudoku(private val puzzle: Array<IntArray>) {

    fun blanksRemaining(): Int {
        val blanks = (puzzle.indices).flatMap { row ->
            (puzzle[row].indices)
                .filter { column -> puzzle[row][column] == 0 }
        }

        return blanks.size
    }

    fun checkCorrectness() : Boolean = checkCorrectnessForRows().and(checkCorrectnessForColumns())

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