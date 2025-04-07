package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.data

enum class PaymentType(private val type: String) {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    AMERICAN_EXPRESS("American Express"),
    PAYPAL("PayPal");
    fun getPaymentType(value: String): String {
        return entries.find { it.type == value }?.type ?: throw IllegalArgumentException(
            INVALID_PAYMENT_TYPE
        )
    }
}
const val INVALID_PAYMENT_TYPE = "Invalid payment type"