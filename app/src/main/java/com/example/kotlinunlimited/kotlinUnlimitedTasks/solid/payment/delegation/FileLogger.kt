package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation

import com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.Logger.Logger
import java.io.File
import java.util.Date

class FileLogger : Logger {
    override fun log(message: String) {
        val file = File("logs.txt")
        file.appendText("SYSTEM LOG: | ${Date()} | $message\n")
    }
}