package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.datasource.TransactionDataSource
import java.util.UUID

internal class DeleteTransaction(private val transactionRepository: TransactionDataSource) {
    fun execute(id: UUID): Boolean {
        return transactionRepository.delete(id)
    }
}
