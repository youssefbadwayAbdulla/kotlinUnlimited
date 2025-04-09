package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.usecase

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.Transaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.TransactionType
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository.TransactionRepository

internal class AddTransactionUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(transaction: Transaction) {
        require(transaction.amount > 0) { "Amount must be greater than zero" }
        require(transaction.title.isNotBlank()) { "Title cannot be blank" }
        require(transaction.category.isNotBlank()) { "Category cannot be blank" }
        require(transaction.date.isBefore(transaction.date.plusDays(1))) { "Date cannot be in the future" }
        require(transaction.type != TransactionType.INCOME || transaction.amount > 0) { "Income transactions must have a positive amount" }
        require(transaction.type != TransactionType.EXPENSE || transaction.amount < 0) { "Expense transactions must have a negative amount" }
        transactionRepository.add(transaction)
    }
}
