package com.apap.sudoku

import com.apap.sudoku.util.Sudoku
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SudokuTest {

    @Test
    fun shouldRejectSolutionWithEmptyPuzzleArray() {
        val puzzle : Array<IntArray> = arrayOf(
        IntArray(9), IntArray(9), IntArray(9),
        IntArray(9), IntArray(9), IntArray(9),
        IntArray(9), IntArray(9), IntArray(9))
        val sudoku = Sudoku(puzzle)

        Assert.assertFalse(sudoku.checkCorrectness())
    }

    @Test
    fun shouldRejectSolutionWithBlanks() {
        val puzzle : Array<IntArray> = arrayOf(
            IntArray(9), IntArray(9), IntArray(9),
            IntArray(9), IntArray(9), IntArray(9),
            IntArray(9), IntArray(9), IntArray(9))
        puzzle.fill(IntArray(9) { 0 }, 0, puzzle.size)
        val sudoku = Sudoku(puzzle)

        Assert.assertFalse(sudoku.checkCorrectness())
    }

    @Test
    fun shouldRejectSolutionWithCorrectRowsAndIncorrectColumns() {
        val puzzle : Array<IntArray> = arrayOf(
            intArrayOf(2,3,4,6,9,5,7,8,1), intArrayOf(7,5,6,1,4,8,2,3,9), intArrayOf(8,1,9,2,3,7,4,6,5),
            intArrayOf(3,8,1,4,5,9,6,2,7), intArrayOf(4,9,2,7,3,6,1,5,8), intArrayOf(5,6,7,8,1,2,3,9,4),
            intArrayOf(1,2,5,7,8,3,9,4,6), intArrayOf(6,7,8,9,2,4,5,1,3), intArrayOf(9,4,3,5,6,1,8,7,2))
        val sudoku = Sudoku(puzzle)

        Assert.assertFalse(sudoku.checkCorrectness())
    }

    @Test
    fun shouldRejectSolutionWithCorrectColumnsAndIncorrectRows() {
        val puzzle : Array<IntArray> = arrayOf(
            intArrayOf(3,3,4,6,9,5,7,8,1), intArrayOf(4,5,6,1,4,8,2,3,9), intArrayOf(8,1,9,2,3,7,4,6,5),
            intArrayOf(2,8,1,4,5,9,6,2,7), intArrayOf(7,9,2,3,7,6,1,5,8), intArrayOf(5,6,7,8,1,2,3,9,4),
            intArrayOf(1,2,5,7,8,3,9,4,6), intArrayOf(6,7,8,9,2,4,5,1,3), intArrayOf(9,4,3,5,6,1,8,7,2))
        val sudoku = Sudoku(puzzle)

        Assert.assertFalse(sudoku.checkCorrectness())
    }

    @Test
    fun shouldRejectSolutionWithIncorrectRowsAndColumns() {
        val puzzle : Array<IntArray> = arrayOf(
            intArrayOf(3,3,4,6,9,5,7,8,1), intArrayOf(5,5,6,1,4,8,2,3,9), intArrayOf(8,1,9,2,3,7,4,6,5),
            intArrayOf(3,8,1,4,5,9,6,2,7), intArrayOf(5,9,2,3,7,6,1,5,8), intArrayOf(5,6,7,8,1,2,3,9,4),
            intArrayOf(1,2,5,7,8,3,9,4,6), intArrayOf(6,7,8,9,2,4,5,1,3), intArrayOf(9,4,3,5,6,1,8,7,2))
        val sudoku = Sudoku(puzzle)

        Assert.assertFalse(sudoku.checkCorrectness())
    }

    @Test
    fun shouldAcceptSolutionWithCorrectRowsColumnsAndSubmatrices() {
        val puzzle : Array<IntArray> = arrayOf(
            intArrayOf(2,3,4,6,9,5,7,8,1), intArrayOf(7,5,6,1,4,8,2,3,9), intArrayOf(8,1,9,2,3,7,4,6,5),
            intArrayOf(3,8,1,4,5,9,6,2,7), intArrayOf(4,9,2,3,7,6,1,5,8), intArrayOf(5,6,7,8,1,2,3,9,4),
            intArrayOf(1,2,5,7,8,3,9,4,6), intArrayOf(6,7,8,9,2,4,5,1,3), intArrayOf(9,4,3,5,6,1,8,7,2))
        val sudoku = Sudoku(puzzle)

        Assert.assertTrue(sudoku.checkCorrectness())
    }
}