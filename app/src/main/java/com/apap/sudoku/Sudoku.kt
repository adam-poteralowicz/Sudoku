package com.apap.sudoku

class Sudoku(private val puzzle: Array<IntArray>) {

    fun checkCorrectness() : Boolean =
        if (blanksRemaining()) false
        else checkRows() && checkColumns() && checkMatrices()

    private fun blanksRemaining(): Boolean {
        val blanks = (puzzle.indices).flatMap { row ->
            (puzzle[row].indices)
                .filter { column -> puzzle[row][column] == 0 }
        }

        return blanks.isNotEmpty()
    }

    private fun checkRows(): Boolean {
        var correctness = false

        puzzle.indices.forEach { row ->
            correctness = isSumCorrect(puzzle[row])
            if (!correctness) {
                return false
            }
        }

        return correctness
    }

    private fun checkColumns() : Boolean {
        var correctness = false
        var column : IntArray

        for (i in 0 until puzzle.size) {
            column = IntArray(puzzle.size)
            var j = 0
            puzzle.indices.forEach { row ->
                column[j] = puzzle[row][i]
                j++
            }

            correctness = isSumCorrect(column)
            if (!correctness) {
                return false
            }
        }

        return correctness
    }

    private fun checkMatrices() : Boolean {

        return checkMatrix(0, 2, 0, 2)
                && checkMatrix(3, 5, 0, 2)
                && checkMatrix(6, 8, 0, 2)
                && checkMatrix(0, 2, 3, 5)
                && checkMatrix(3, 5, 3, 5)
                && checkMatrix(6, 8, 3, 5)
                && checkMatrix(0, 2, 6, 8)
                && checkMatrix(3, 5, 6, 8)
                && checkMatrix(6, 8, 6, 8)
    }

    private fun checkMatrix(index1: Int, index2: Int, index3: Int, index4: Int) : Boolean {

        val matrix = puzzle.sliceArray(index1..index2)
        val values = ArrayList<Int>()

        for (i in 0 until matrix.size) {
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

    private fun isSumCorrect(list: ArrayList<Int>) : Boolean {
        return list.distinct().reduce { acc, digit -> acc + digit } == 45
    }
}