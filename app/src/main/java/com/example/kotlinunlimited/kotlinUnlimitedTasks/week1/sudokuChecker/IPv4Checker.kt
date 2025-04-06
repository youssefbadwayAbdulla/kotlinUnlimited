package com.example.kotlinunlimited.kotlinUnlimitedTasks.week1.sudokuChecker

object IPv4Checker {
    fun isValidIPv4(ip: String): Boolean {
        val parts = ip.split(".")
        if (parts.size != 4) return false

        for (part in parts) {
            if (part.isEmpty()) return false
            if (part.length > 1 && part.startsWith("0")) return false
            val num = part.toIntOrNull() ?: return false
            if (num !in 0..255) return false
        }

        return true
    }

}

