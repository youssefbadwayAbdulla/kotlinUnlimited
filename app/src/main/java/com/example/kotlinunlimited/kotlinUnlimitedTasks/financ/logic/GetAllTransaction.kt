package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.datasource.TransactionDataSource
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.Transaction

internal class GetAllTransaction(private val transactionRepository: TransactionDataSource) {
    fun execute(): List<Transaction> {
        return transactionRepository.getAll()
    }
}