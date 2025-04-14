package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.datasource.TransactionDataSource
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.Transaction
import java.util.UUID

internal class FindTransactionById (private val transactionRepository: TransactionDataSource) {
    fun execute(id: UUID): Transaction? {
        return  transactionRepository.findTransactionById(id)
    }
}