package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.PaymentStrategy

class PayPalPaymentStrategy: PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing PayPal payment of $amount")
    }
}