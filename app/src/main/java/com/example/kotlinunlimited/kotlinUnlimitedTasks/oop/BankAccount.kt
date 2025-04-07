package com.example.kotlinunlimited.kotlinUnlimitedTasks.oop

import java.util.UUID

class BankAccount(private val accountName: String) {
    private var balance: Double = 0.0
    private var transactions: MutableList<String> = mutableListOf()

    init {
        println("Welcome to our bank account created for $accountName")
    }

    fun withdraw(amount: Double) {
        if (balance == 0.0) return println("Account is empty : $balance")
        if (balance >= amount) {
            balance -= amount
            transactions.add("Withdrew process $amount")
            println("Withdrew $amount. New balance: $balance")
        } else {
            println("Insufficient funds. Current balance: $balance")
        }
    }

    fun getBalance(): Double {
        println("Current balance: $balance")
        return balance
    }

    fun deposit(amount: Double) {
        balance += amount
        transactions.add("Deposited process $amount")
        println("Deposited $amount. New balance: $balance")
    }
    fun getTransactions(): List<String> {
        println("Transactions:")
        transactions.forEach { println(it) }
        return transactions
    }

    fun getUserId(accountId: UUID = UUID.randomUUID()): UUID {
        println("User ID $accountName is: $accountId")
        return accountId
    }
}