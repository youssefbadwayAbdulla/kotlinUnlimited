package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.data.repository

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.Transaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository.TransactionRepository
import java.time.YearMonth
import java.util.UUID

internal class InMemoryTransactionRepository : TransactionRepository {
    private val transactions = mutableListOf<Transaction>()

    override fun add(transaction: Transaction) {
        transactions.add(transaction)
    }

    override fun update(transaction: Transaction) {
        val index = transactions.indexOfFirst { it.id == transaction.id }
        if (index != -1) transactions[index] = transaction
        else transactions.add(transaction)
    }

    override fun delete(id: UUID): Boolean {
        return transactions.removeIf { it.id == id }
    }

    override fun getAll(): List<Transaction> {
        return transactions
    }

    override fun findTransactionById(id: UUID): Transaction? {
        return transactions.find { it.id == id }
    }

    override fun getTransactionByMonth(month: YearMonth): List<Transaction> {
        return transactions.filter {
            YearMonth.from(it.date) == month
        }
    }
}