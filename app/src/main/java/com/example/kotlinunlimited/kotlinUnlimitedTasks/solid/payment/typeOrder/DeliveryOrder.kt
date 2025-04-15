package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typeOrder

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.ShippingCostCalculator
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.Order
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.Logger.Logger

class DeliveryOrder(private val logger: Logger) : Order(), ShippingCostCalculator , Logger by logger {
    override val shippingCost: Double = 10.0
    override val amountOrder: Double = 300.0
    override fun calculatorShippingCost(): Double {
        log("Calculating shipping cost for delivery order : ${amountOrder + shippingCost}")
        return amountOrder + shippingCost
    }

}