package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment

interface PaymentStrategy {
    fun processPayment(amount: Double)
}