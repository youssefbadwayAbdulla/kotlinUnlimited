package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.usecase

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository.TransactionRepository
import java.util.UUID

internal class DeleteTransactionUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(id: UUID): Boolean {
        return transactionRepository.delete(id)
    }
}
