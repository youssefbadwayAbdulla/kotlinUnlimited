package com.example.kotlinunlimited.kotlinUnlimitedTasks.oop

fun main() {
    val user = BankAccount("Youssef")
    user.getUserId()
    user.deposit(1000.0)
    user.withdraw(500.0)
    user.getBalance()
    user.getTransactions()



}