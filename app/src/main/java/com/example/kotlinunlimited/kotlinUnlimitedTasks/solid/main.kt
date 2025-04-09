package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.PaymentProcessor
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.Order
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.PaymentType
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typeOrder.DeliveryOrder
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typeOrder.PickUpOrder

fun main() {
    val paymentProcessor = PaymentProcessor()
    paymentProcessor.processPayment(
        order = Order(
            amountOrder = 100.0,
            currencyOrder = "USD",
            nameOrder = "Order 1",
            orderType = PaymentType.VISA
        )
    )
    val order: Order = PickUpOrder()
    order.getTotalPrice()


}