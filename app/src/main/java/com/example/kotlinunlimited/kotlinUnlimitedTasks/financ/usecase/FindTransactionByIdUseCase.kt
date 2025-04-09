package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.usecase

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.Transaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository.TransactionRepository
import java.util.UUID

internal class FindTransactionByIdUseCase (private val transactionRepository: TransactionRepository) {
    fun execute(id: UUID): Transaction? {
        return  transactionRepository.findTransactionById(id)
    }
}