package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.datasource.TransactionDataSource
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.MonthlySummary
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.TransactionType
import java.time.YearMonth

internal class MonthlySummary(private val transactionRepository: TransactionDataSource) {
    fun execute(month: YearMonth): MonthlySummary {
        val transactions = transactionRepository.getTransactionByMonth(month)
        val income = transactions.filter { it.type == TransactionType.INCOME }.sumOf { it.amount }
        val expenses = transactions.filter { it.type == TransactionType.EXPENSE }.sumOf { it.amount }
        return MonthlySummary(income, expenses, income - expenses)
    }
}