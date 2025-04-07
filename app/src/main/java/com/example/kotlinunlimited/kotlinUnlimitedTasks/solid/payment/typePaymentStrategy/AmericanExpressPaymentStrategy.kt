package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.PaymentStrategy

class AmericanExpressPaymentStrategy: PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing American Express payment of $amount")
    }
}