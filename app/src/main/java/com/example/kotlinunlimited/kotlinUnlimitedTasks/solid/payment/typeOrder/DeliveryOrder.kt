package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typeOrder

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.ShippingCostCalculator
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.Order

class DeliveryOrder : Order(), ShippingCostCalculator {
    override val shippingCost: Double = 10.0
    override val amountOrder: Double = 300.0
    override fun calculatorShippingCost(): Double {
        println("Calculating shipping cost for delivery order : ${amountOrder + shippingCost}")
        return amountOrder + shippingCost
    }

}