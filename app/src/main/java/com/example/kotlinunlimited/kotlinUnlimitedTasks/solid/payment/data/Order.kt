package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data

class Order(
    val amountOrder: Double = 0.0,
    val currencyOrder: String = "",
    val nameOrder: String = "",
    val orderType: PaymentType
) {

    fun validateOrder():Boolean {
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


}