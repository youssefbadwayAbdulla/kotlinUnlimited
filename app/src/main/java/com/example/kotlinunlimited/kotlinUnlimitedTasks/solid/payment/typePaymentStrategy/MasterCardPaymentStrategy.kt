package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.PaymentStrategy

class MasterCardPaymentStrategy: PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing MasterCard payment of $amount")
    }
}