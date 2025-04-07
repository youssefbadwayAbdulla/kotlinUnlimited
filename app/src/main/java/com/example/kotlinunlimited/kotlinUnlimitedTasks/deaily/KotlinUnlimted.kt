package com.example.kotlinunlimited.kotlinUnlimitedTasks.deaily

fun main() {
println(getTheFirstEvenNumber(listOf(1, 2, 3, 4, 5)))
}

fun getTheFirstEvenNumber(numbers: List<Int>): Int {
    numbers.forEachIndexed { index, value ->
        if (value % 2 == 0) return index
    }
    return -1
}