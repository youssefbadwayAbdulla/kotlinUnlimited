package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment

interface ShippingCostCalculator { // this for Liskov substitution principle
    fun calculatorShippingCost(): Double
}