package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ


/*
com.finance
│
│   ├── model
│   │   └── Transaction.kt ،MonthlySummary.kt
│   └── dataSource
│       └── TransactionRepository.kt
│       └── TransactionDataSourceIMP.kt
├── cli/
│   └── FinanceTrackerApp.kt
│
└── Main.kt
*/

import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.datasource.TransactionDataSourceIMP
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic.AddTransaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic.DeleteTransaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic.EditTransaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic.FindTransactionById
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic.GetAllTransaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.logic.MonthlySummary
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.Transaction
import com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.model.TransactionType
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeParseException
import java.util.UUID

class FinanceTrackerApp {
    private val transactionRepository = TransactionDataSourceIMP()
    private val addTransaction = AddTransaction(transactionRepository)
    private val editTransaction = EditTransaction(transactionRepository)
    private val deleteTransaction = DeleteTransaction(transactionRepository)
    private val monthlySummary = MonthlySummary(transactionRepository)
    private val getAllTransaction = GetAllTransaction(transactionRepository)
    private val findTransactionById = FindTransactionById(transactionRepository)

    fun start() {
        println("Welcome to Personal Finance Tracker\n")
        while (true) {
            showMenu()
            when (readlnOrNull()) {
                "1" -> addTransaction()
                "2" -> viewAllTransactions()
                "3" -> viewMonthlySummary()
                "4" -> editTransaction()
                "5" -> deleteTransaction()
                "0" -> break
            }
        }
    }

    private fun showMenu() {
        println(
            """
            |Choose an option:
            |1. Add Transaction
            |2. View All Transactions
            |3. View Monthly Summary
            |4. Edit Transaction
            |5. Delete Transaction
            |0. Exit
            """.trimMargin()
        )
    }

    private fun addTransaction() {
        val title = promptForInput("Enter title:")
        val amount = promptForAmount("Enter amount:") ?: return
        val type = promptForTransactionType("Enter type (income/expense):") ?: return
        val category = promptForInput("Enter category:")
        val date = promptForDate("Enter date (yyyy-MM-dd):") ?: return

        val transaction = Transaction(
            title = title,
            amount = amount,
            type = type,
            category = category,
            date = date
        )
        addTransaction.execute(transaction)
        println("${transaction.id} | ${transaction.title} |     | ${transaction.type} | ${transaction.category} | ${transaction.amount} | ${transaction.date}")
        println("✅ Transaction added!\n")
    }

    private fun editTransaction() {
        while (true) {
            println("Enter the ID of the transaction to edit (or type 'exit' to cancel):")
            val idInput = readlnOrNull().orEmpty()

            if (idInput.equals("exit", ignoreCase = true)) {
                println("❌ Editing canceled.")
                return
            }

            val id = try {
                UUID.fromString(idInput)
            } catch (e: IllegalArgumentException) {
                println("❌ Invalid UUID format. Please enter a valid UUID.")
                continue
            }
            val existing = findTransactionById.execute(id)
            if (existing == null) {
                println("❌ Transaction not found. Please check the ID and try again.")
                continue
            }

            val title = promptForInput("Enter new title [${existing.title}]:", existing.title)
            val amount =
                promptForAmount("Enter new amount [${existing.amount}]:") ?: existing.amount
            val type =
                promptForTransactionType("Enter new type (income/expense) [${existing.type}]:")
                    ?: existing.type
            val category =
                promptForInput("Enter new category [${existing.category}]:", existing.category)
            val date =
                promptForDate("Enter new date (yyyy-MM-dd) [${existing.date}]:") ?: existing.date

            val updated = existing.copy(
                title = title,
                amount = amount,
                type = type,
                category = category,
                date = date
            )

            editTransaction.execute(updated)
            println("Transaction updated: ${updated.id} | ${updated.title} | ${updated.type} | ${updated.category} | ${updated.amount} | ${updated.date}")
            println("✅ Transaction updated!\n")
            return
        }
    }

    private fun deleteTransaction() {
        println("Enter the ID of the transaction to delete:")
        val input = readlnOrNull().orEmpty()
        val id = try {
            UUID.fromString(input)
        } catch (e: IllegalArgumentException) {
            println("❌ Invalid UUID format.")
            return
        }

        if (deleteTransaction.execute(id)) {
            println("✅ Transaction deleted.\n")
        } else {
            println("❌ Transaction not found.\n")
        }
    }

    private fun viewAllTransactions() {
        val list = getAllTransaction.execute()
        if (list.isEmpty()) {
            println("No transactions found.\n")
            return
        }
        list.forEach {
            println("${it.id} | ${it.title} |     | ${it.type} | ${it.category} | ${it.amount} | ${it.date}")
        }
        println()
    }

    private fun viewMonthlySummary() {
        print("Enter month (yyyy-mm): ")
        val ymInput = readlnOrNull().orEmpty()
        try {
            val ym = YearMonth.parse(ymInput)
            val summary = monthlySummary.execute(ym)
            println("Income: ${summary.income}")
            println("Expenses: ${summary.expenses}")
            println("Balance: ${summary.balance}\n")
        } catch (e: DateTimeParseException) {
            println("❌ Invalid month format! Please use yyyy-mm.")
        }
    }

    private fun promptForInput(prompt: String, defaultValue: String = ""): String {
        print("$prompt ")
        val input = readlnOrNull()?.ifBlank { defaultValue }
        return input.orEmpty()
    }

    private fun promptForAmount(prompt: String): Double? {
        print(prompt)
        return readlnOrNull()?.toDoubleOrNull()
    }

    private fun promptForTransactionType(prompt: String): TransactionType? {
        print("$prompt ")
        return when (readlnOrNull()?.lowercase()) {
            "income" -> TransactionType.INCOME
            "expense" -> TransactionType.EXPENSE
            else -> null
        }
    }

    private fun promptForDate(prompt: String): LocalDate? {
        var date: LocalDate? = null
        while (date == null) {
            print("$prompt ")
            val dateInput = readlnOrNull().orEmpty()
            try {
                date = LocalDate.parse(dateInput)
            } catch (e: DateTimeParseException) {
                println("❌ Invalid date format! Please use yyyy-MM-dd.")
            }
        }
        return date
    }
}