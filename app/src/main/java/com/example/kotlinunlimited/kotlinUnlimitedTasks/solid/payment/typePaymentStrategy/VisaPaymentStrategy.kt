package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.Logger.Logger
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.PaymentStrategy

class VisaPaymentStrategy(private val logger: Logger): PaymentStrategy , Logger by logger {
    override fun processPayment(amount: Double) {
        log("Processing Visa payment of $amount")
    }
}