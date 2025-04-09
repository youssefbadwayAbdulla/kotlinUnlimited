package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.typeOrder

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.ShippingCostCalculator
import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data.Order

class PickUpOrder : Order(), ShippingCostCalculator {
    override val amountOrder: Double = 300.0
    override fun calculatorShippingCost(): Double {
        println("Calculating shipping cost for pick up order : $amountOrder")
        return amountOrder
    }
}