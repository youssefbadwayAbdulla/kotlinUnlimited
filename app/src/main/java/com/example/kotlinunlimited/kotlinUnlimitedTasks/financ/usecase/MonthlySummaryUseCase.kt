package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.usecase

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.MonthlySummary
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model.TransactionType
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.repository.TransactionRepository
import java.time.YearMonth

internal class MonthlySummaryUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(month: YearMonth): MonthlySummary {
        val transactions = transactionRepository.getTransactionByMonth(month)
        val income = transactions.filter { it.type == TransactionType.INCOME }.sumOf { it.amount }
        val expenses = transactions.filter { it.type == TransactionType.EXPENSE }.sumOf { it.amount }
        return MonthlySummary(income, expenses, income - expenses)
    }
}