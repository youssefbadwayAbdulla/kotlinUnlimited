package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.PaymentStrategy

class VisaPaymentStrategy: PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing Visa payment of $amount")
    }
}