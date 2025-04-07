package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.Order
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.PaymentType
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.AmericanExpressPaymentStrategy
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.MasterCardPaymentStrategy
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.PayPalPaymentStrategy
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.VisaPaymentStrategy

class PaymentProcessor {
    private lateinit var paymentStrategy: PaymentStrategy

    fun processPayment(order: Order) {
        println("Processing payment for order: ${order.getName()}")
        println("Amount: ${order.getAmount()}")
        println("Currency: ${order.getCurrency()}")
        if (order.validateOrder()) {
            paymentStrategy = setPaymentStrategyType(order.orderType)
            paymentStrategy.processPayment(order.amountOrder)
            println("Payment processed successfully")
        } else {
            println("Payment failed due to invalid order.")
        }

    }

    private fun setPaymentStrategyType(paymentType: PaymentType): PaymentStrategy {
        return when (paymentType) {
            PaymentType.VISA -> VisaPaymentStrategy()
            PaymentType.MASTERCARD -> MasterCardPaymentStrategy()
            PaymentType.AMERICAN_EXPRESS -> AmericanExpressPaymentStrategy()
            PaymentType.PAYPAL -> PayPalPaymentStrategy()
        }
    }
}