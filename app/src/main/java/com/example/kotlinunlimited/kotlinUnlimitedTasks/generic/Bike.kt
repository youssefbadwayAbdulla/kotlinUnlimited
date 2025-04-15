package com.example.kotlinunlimited.kotlinUnlimitedTasks.generic

data class Bike(
    val id: Int,
    val brand: String,
    val model: String,
    val year: Int,
    val color: String,
    val price: Double,
    val capacity: Int,
): Vehicle
