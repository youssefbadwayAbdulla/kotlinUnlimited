package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.Transaction
import java.time.YearMonth
import java.util.UUID

internal interface TransactionRepository {
    fun add(transaction: Transaction)
    fun update(transaction: Transaction)
    fun delete(id: UUID): Boolean
    fun getAll(): List<Transaction>
    fun findTransactionById(id: UUID): Transaction?
    fun getTransactionByMonth(month: YearMonth): List<Transaction>
}