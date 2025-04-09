package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data

open class Order(
    open val amountOrder: Double = 0.0,
    val currencyOrder: String = "",
    val nameOrder: String = "",
    val orderType: PaymentType = PaymentType.VISA,
    open val shippingCost: Double = 0.0
) {

    fun validateOrder(): Boolean {
        require(amountOrder > 0) { "Amount must be greater than zero" }
        require(currencyOrder.isNotEmpty()) { "Currency cannot be empty" }
        require(nameOrder.isNotEmpty()) { "Name cannot be empty" }
        return true
    }

    fun getAmount(): Double {
        return amountOrder
    }

    fun getCurrency(): String {
        return currencyOrder
    }

    fun getName(): String {
        return nameOrder
    }
    fun getTotalPrice(): Double { // this for Liskov substitution principle
        println("Total price: ${amountOrder + shippingCost}")
        return amountOrder + shippingCost
    }
}