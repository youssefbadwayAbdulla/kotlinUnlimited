package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.datasource

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.Transaction
import java.time.YearMonth
import java.util.UUID

/**
 * ✅ Use mutableMapOf<K, V>() (a MutableMap) when:
 * You need fast lookup by a unique key, such as an id.
 *
 * You're storing items that are best accessed using a unique identifier like a UUID.
 *
 * You want to prevent duplicate entries based on key.
 */
internal class TransactionDataSourceIMP : TransactionDataSource {
    private val transactions = mutableMapOf<UUID, Transaction>()

    override fun add(transaction: Transaction) {
        transactions[transaction.id] = transaction
    }

    override fun update(transaction: Transaction) {
        if (transactions.containsKey(transaction.id)) transactions[transaction.id] = transaction
        else throw IllegalArgumentException("Transaction with ID ${transaction.id} not found.")

    }

    override fun delete(id: UUID): Boolean {
        return transactions.remove(id) != null
    }

    override fun getAll(): List<Transaction> = transactions.values.toList()

    override fun findTransactionById(id: UUID): Transaction? {
        return transactions[id]
    }

    override fun getTransactionByMonth(month: YearMonth): List<Transaction> {
        return transactions.values.filter {
            YearMonth.from(it.date) == month
        }
    }

}