package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.datasource.TransactionDataSource
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.Transaction

internal class EditTransaction(private val transactionRepository: TransactionDataSource) {
    fun execute(transaction: Transaction) {
        val existing = transactionRepository.findTransactionById(transaction.id)
            ?: throw IllegalArgumentException("Transaction with ID ${transaction.id} not found.")
        transactionRepository.update(transaction.copy(id = existing.id))

    }

}