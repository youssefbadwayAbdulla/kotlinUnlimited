package com.example.kotlinunlimited.kotlinUnlimitedTasks.sudokuChecker

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * - Sudoku Checker Test Cases:
 *
 * This test suite validates the SudokuChecker class using multiple board sizes.
 * The tests follow TDD principles to ensure correct behavior.
 *
 * Each test case verifies the correctness of Sudoku validation in different scenarios.
 */

class SudokuCheckerTest {

    private val sudokuChecker = SudokuChecker()

    /**
     * - Test: isValidSudoku_GivenValid4x4Board_ShouldReturnTrue
     * - Scenario: A 4x4 Sudoku board is provided without duplicates.
     * - Expected Result: The board is valid, and the function should return true.
     */
    @Test
    fun isValidSudoku_GivenValid4x4Board_ShouldReturnTrue() {
        val validSudoku = listOf(
            listOf('1', '2', '-', '3'),
            listOf('3', '4', '-', '1'),
            listOf('-', '1', '3', '2'),
            listOf('2', '-', '1', '4')
        )
        assertTrue(sudokuChecker.isValidSudoku(validSudoku))
    }

    /**
     * - Test: isValidSudoku_GivenInvalid4x4Board_ShouldReturnFalse
     * - Scenario: A 4x4 Sudoku board contains duplicates in a row and a column.
     * - Expected Result: The board is invalid, and the function should return false.
     */
    @Test
    fun isValidSudoku_GivenInvalid4x4Board_ShouldReturnFalse() {
        val invalidSudoku = listOf(
            listOf('1', '2', '1', '3'), // ❌ Duplicate '1' in row
            listOf('3', '4', '-', '1'),
            listOf('-', '1', '3', '2'),
            listOf('2', '-', '4', '4')  // ❌ Duplicate '4' in column
        )
        assertFalse(sudokuChecker.isValidSudoku(invalidSudoku))
    }

    /**
     * - Test: isValidSudoku_GivenInvalid4x3Board_ShouldReturnFalse
     * - Scenario: A 4x3 board contains duplicates in a row.
     * - Expected Result: The board is invalid, and the function should return false.
     */
    @Test
    fun isValidSudoku_GivenInvalid4x3Board_ShouldReturnFalse() {
        val invalidSudoku = listOf(
            listOf('1', '2', '3'),
            listOf('3', '1', '2'),
            listOf('2', '3', '2'), // ❌ Duplicate '2' in this row
            listOf('-', '-', '-')
        )
        assertFalse(sudokuChecker.isValidSudoku(invalidSudoku))
    }

    /**
     * - Test: isValidSudoku_GivenValid9x9Board_ShouldReturnTrue
     * - Scenario: A valid 9x9 Sudoku board is given.
     * - Expected Result: The board follows Sudoku rules, and the function should return true.
     */
    @Test
    fun isValidSudoku_GivenValid9x9Board_ShouldReturnTrue() {
        val validSudoku = listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )
        assertTrue(sudokuChecker.isValidSudoku(validSudoku))
    }

    /**
     * - Test: isValidSudoku_GivenInvalid9x9Board_ShouldReturnFalse
     * - Scenario: A 9x9 Sudoku board contains a duplicate number in a row.
     * - Expected Result: The board is invalid, and the function should return false.
     */
    @Test
    fun isValidSudoku_GivenInvalid9x9Board_ShouldReturnFalse() {
        val invalidSudoku = listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '8') // ❌ Duplicate '8'
        )
        assertFalse(sudokuChecker.isValidSudoku(invalidSudoku))
    }

    /**
     * - Test: isValidSudoku_GivenValid16x16Board_ShouldReturnTrue
     * - Scenario: A 16x16 Sudoku board is provided with all empty cells.
     * - Expected Result: The board is valid, and the function should return true.
     */
    @Test
    fun isValidSudoku_GivenValid16x16Board_ShouldReturnTrue() {
        val validSudoku = List(16) { List(16) { '-' } }
        assertTrue(sudokuChecker.isValidSudoku(validSudoku))
    }

    /**
     * - Test: isValidSudoku_GivenInvalid16x16Board_ShouldReturnFalse
     * - Scenario: A 16x16 Sudoku board contains a duplicate character in a sub-box.
     * - Expected Result: The board is invalid, and the function should return false.
     */
    @Test
    fun isValidSudoku_GivenInvalid16x16Board_ShouldReturnFalse() {
        val invalidSudoku = List(16) { MutableList(16) { '-' } }
        invalidSudoku[0][0] = 'A'
        invalidSudoku[1][1] = 'A' // ❌ Duplicate in sub-box
        assertFalse(sudokuChecker.isValidSudoku(invalidSudoku))
    }

    /**
     * - Test: isValidSudoku_GivenEmptyBoard_ShouldReturnTrue
     * - Scenario: An empty Sudoku board (empty list) is given.
     * - Expected Result: The board is considered valid.
     */
    @Test
    fun isValidSudoku_GivenEmptyBoard_ShouldReturnTrue() {
        val emptySudoku = listOf<List<Char>>() // Empty list
        assertTrue(sudokuChecker.isValidSudoku(emptySudoku))
    }

    /**
     * - Test: isValidSudoku_GivenSingleElementBoard_ShouldReturnTrue
     * - Scenario: A 1x1 Sudoku board with a single number is provided.
     * - Expected Result: The board is valid, and the function should return true.
     */
    @Test
    fun isValidSudoku_GivenSingleElementBoard_ShouldReturnTrue() {
        val singleElementSudoku = listOf(listOf('1')) // ✅ 1×1 Sudoku
        assertTrue(sudokuChecker.isValidSudoku(singleElementSudoku))
    }
}

