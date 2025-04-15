package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.PaymentProcessor
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.Order
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.PaymentType
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.FileLogger
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.Logger.Logger
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.Logger.LoggerConsole
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typeOrder.PickUpOrder

fun main() {
    val logger: Logger = FileLogger()
    val paymentProcessor = PaymentProcessor(logger)
    paymentProcessor.processPayment(
        order = Order(
            amountOrder = 100.0,
            currencyOrder = "USD",
            nameOrder = "Order 1",
            orderType = PaymentType.AMERICAN_EXPRESS
        )
    )
    val order: Order = PickUpOrder(logger)
    order.getTotalPrice()


}