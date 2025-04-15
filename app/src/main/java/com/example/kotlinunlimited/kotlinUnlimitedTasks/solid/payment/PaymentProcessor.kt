package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.Logger.Logger
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.Order
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.PaymentType
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.AmericanExpressPaymentStrategy
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.MasterCardPaymentStrategy
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.PayPalPaymentStrategy
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typePaymentStrategy.VisaPaymentStrategy

class PaymentProcessor(private val logger: Logger) : Logger by logger {
    private lateinit var paymentStrategy: PaymentStrategy

    fun processPayment(order: Order) {
        log("Processing payment for order: ${order.getName()}")
        log("Amount: ${order.getAmount()}")
        log("Currency: ${order.getCurrency()}")
        if (order.validateOrder()) {
            paymentStrategy = setPaymentStrategyType(order.orderType)
            paymentStrategy.processPayment(order.amountOrder)
            log("Payment processed successfully")
        } else {
            log("Payment failed due to invalid order.")
        }

    }

    private fun setPaymentStrategyType(paymentType: PaymentType): PaymentStrategy {
        return when (paymentType) {
            PaymentType.VISA -> VisaPaymentStrategy(logger)
            PaymentType.MASTERCARD -> MasterCardPaymentStrategy(logger)
            PaymentType.AMERICAN_EXPRESS -> AmericanExpressPaymentStrategy(logger)
            PaymentType.PAYPAL -> PayPalPaymentStrategy(logger)
        }
    }
}