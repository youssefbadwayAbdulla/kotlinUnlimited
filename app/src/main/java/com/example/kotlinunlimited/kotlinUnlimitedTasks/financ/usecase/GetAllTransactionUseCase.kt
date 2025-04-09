package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.usecase

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.Transaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository.TransactionRepository

internal class GetAllTransactionUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(): List<Transaction> {
        return transactionRepository.getAll()
    }
}