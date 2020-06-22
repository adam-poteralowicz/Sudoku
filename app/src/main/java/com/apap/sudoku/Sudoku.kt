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

    // FIXME returns wrong result
    fun checkCorrectness() : Boolean =
        if (blanksRemaining() > 0) false
        else checkCorrectnessForRows() && checkCorrectnessForColumns() && checkCorrectnessForMatrices()

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

        for (i in 0 until puzzle.size) {
            column = IntArray(puzzle.size)
            var j = 0
            puzzle.indices.forEach { row ->
                column[j] = puzzle[row][i]
                j++
            }

            println(column.contentToString())
            correctness = isSumCorrect(column)
            if (!correctness) {
                return false
            }
        }

        return correctness
    }

    private fun checkCorrectnessForMatrices() : Boolean {

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