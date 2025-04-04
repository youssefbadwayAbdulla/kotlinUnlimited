package com.example.kotlinunlimited.kotlinUnlimitedTasks.sudokuChecker

import kotlin.math.sqrt

class SudokuChecker {

    fun isValidSudoku(board: List<List<Char>>): Boolean {
        val size = board.size
        val boxSize = sqrt(size.toDouble()).toInt()

        if (!isValidBoardSize(board, size, boxSize)) return false

        val rows = Array(size) { mutableSetOf<Char>() }
        val cols = Array(size) { mutableSetOf<Char>() }
        val boxes = Array(size) { mutableSetOf<Char>() }

        return board.indices.all { r ->
            board[r].indices.all { c ->
                val num = board[r][c]
                if (num == '-') true else isValidEntry(num, r, c, boxSize, rows, cols, boxes)
            }
        }
    }

    private fun isValidBoardSize(board: List<List<Char>>, size: Int, boxSize: Int): Boolean {
        if (board.isEmpty() || board[0].isEmpty()) return true // ✅ Handle empty board case safely
        return size == board[0].size && boxSize * boxSize == size
    }

    private fun isValidEntry(
        num: Char, r: Int, c: Int, boxSize: Int,
        rows: Array<MutableSet<Char>>, cols: Array<MutableSet<Char>>, boxes: Array<MutableSet<Char>>
    ): Boolean {
        val boxIndex = (r / boxSize) * boxSize + (c / boxSize)
        return rows[r].add(num) && cols[c].add(num) && boxes[boxIndex].add(num)
    }
}


/**
 * Explanation of the Implementation
 * Extracts the Sudoku grid size and calculates the box size dynamically.
 *
 * Uses sets (HashSet) to track unique values in rows, columns, and boxes.
 *
 * Iterates over each cell:
 *
 * If it’s '-' (empty), it is ignored.
 *
 * Otherwise, checks if the number already exists in the corresponding row, column, or box.
 *
 * If any duplicate is found, returns false; otherwise, returns true.



 * Improvements:
 * Better Structure: Extracted validation logic into separate functions for better readability.
 *
 * Higher Readability: Used all { } for a cleaner loop structure.
 *
 * Improved Efficiency: Eliminated redundant checks.
 *
 * Scalability: Works efficiently for different Sudoku sizes (e.g., 4×4, 16×16).
 *
 * This version ensures clarity, performance, and expandability while maintaining correctness. 🚀 Let me know if you need further enhancements!
 */