package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.usecase

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.Transaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository.TransactionRepository

internal class EditTransactionUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(transaction: Transaction) {
        val existing = transactionRepository.findTransactionById(transaction.id)
            ?: throw IllegalArgumentException("Transaction with ID ${transaction.id} not found.")
        transactionRepository.update(transaction.copy(id = existing.id))

    }

}