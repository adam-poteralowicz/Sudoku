package com.apap.sudoku

import com.apap.sudoku.util.Board
import com.apap.sudoku.util.Sudoku
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SudokuTest {

    private lateinit var emptyPuzzle: Array<Board.Row>

    @Test
    fun shouldRejectSolutionWithEmptyPuzzleArray() {
        val emptyPuzzle = Array(9) { Board.Row() }
        val sudoku = Sudoku(emptyPuzzle)

        assertFalse(sudoku.validate())
    }

    @Test
    fun shouldRejectSolutionWithCorrectRowsAndIncorrectColumns() {
        val puzzle: Array<Board.Row> = arrayOf(
            row(2, 3, 4, 6, 9, 5, 7, 8, 1),
            row(7, 5, 6, 1, 4, 8, 2, 3, 9),
            row(8, 1, 9, 2, 3, 7, 4, 6, 5),
            row(3, 8, 1, 4, 5, 9, 6, 2, 7),
            row(4, 9, 2, 7, 3, 6, 1, 5, 8),
            row(5, 6, 7, 8, 1, 2, 3, 9, 4),
            row(1, 2, 5, 7, 8, 3, 9, 4, 6),
            row(6, 7, 8, 9, 2, 4, 5, 1, 3),
            row(9, 4, 3, 5, 6, 1, 8, 7, 2)
        )
        val sudoku = Sudoku(puzzle)

        assertFalse(sudoku.validate())
    }

    @Test
    fun shouldRejectSolutionWithCorrectColumnsAndIncorrectRows() {
        val puzzle: Array<Board.Row> = arrayOf(
            row(3, 3, 4, 6, 9, 5, 7, 8, 1),
            row(4, 5, 6, 1, 4, 8, 2, 3, 9),
            row(8, 1, 9, 2, 3, 7, 4, 6, 5),
            row(2, 8, 1, 4, 5, 9, 6, 2, 7),
            row(7, 9, 2, 3, 7, 6, 1, 5, 8),
            row(5, 6, 7, 8, 1, 2, 3, 9, 4),
            row(1, 2, 5, 7, 8, 3, 9, 4, 6),
            row(6, 7, 8, 9, 2, 4, 5, 1, 3),
            row(9, 4, 3, 5, 6, 1, 8, 7, 2)
        )
        val sudoku = Sudoku(puzzle)

        assertFalse(sudoku.validate())
    }

    @Test
    fun shouldRejectSolutionWithIncorrectRowsAndColumns() {
        val puzzle: Array<Board.Row> = arrayOf(
            row(3, 3, 4, 6, 9, 5, 7, 8, 1),
            row(5, 5, 6, 1, 4, 8, 2, 3, 9),
            row(8, 1, 9, 2, 3, 7, 4, 6, 5),
            row(3, 8, 1, 4, 5, 9, 6, 2, 7),
            row(5, 9, 2, 3, 7, 6, 1, 5, 8),
            row(5, 6, 7, 8, 1, 2, 3, 9, 4),
            row(1, 2, 5, 7, 8, 3, 9, 4, 6),
            row(6, 7, 8, 9, 2, 4, 5, 1, 3),
            row(9, 4, 3, 5, 6, 1, 8, 7, 2)
        )
        val sudoku = Sudoku(puzzle)

        assertFalse(sudoku.validate())
    }

    @Test
    fun shouldAcceptSolutionWithCorrectRowsColumnsAndSubMatrices() {
        val puzzle: Array<Board.Row> = arrayOf(
            row(2, 3, 4, 6, 9, 5, 7, 8, 1),
            row(7, 5, 6, 1, 4, 8, 2, 3, 9),
            row(8, 1, 9, 2, 3, 7, 4, 6, 5),
            row(3, 8, 1, 4, 5, 9, 6, 2, 7),
            row(4, 9, 2, 3, 7, 6, 1, 5, 8),
            row(5, 6, 7, 8, 1, 2, 3, 9, 4),
            row(1, 2, 5, 7, 8, 3, 9, 4, 6),
            row(6, 7, 8, 9, 2, 4, 5, 1, 3),
            row(9, 4, 3, 5, 6, 1, 8, 7, 2)
        )
        val sudoku = Sudoku(puzzle)

        assertTrue(sudoku.validate())
    }

    private fun row(vararg digits: Int) = Board.Row().apply { this.set(digits) }
}
