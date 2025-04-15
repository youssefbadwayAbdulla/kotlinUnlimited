package com.example.kotlinunlimited.kotlinUnlimitedTasks.solid.payment.delegation.Logger

import java.util.Date

class LoggerConsole : Logger {
    override fun log(message: String) {
        println("SYSTEM LOG: | ${Date()} | $message")
    }
}