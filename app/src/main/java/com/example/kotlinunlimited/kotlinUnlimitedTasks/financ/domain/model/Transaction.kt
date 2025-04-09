package com.example.kotlinunlimited.kotlinUnlimitedTasks.financ.domain.model

import java.time.LocalDate
import java.util.UUID

internal data class Transaction(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var amount: Double,
    var type: TransactionType,
    var category: String,
    var date: LocalDate
)
