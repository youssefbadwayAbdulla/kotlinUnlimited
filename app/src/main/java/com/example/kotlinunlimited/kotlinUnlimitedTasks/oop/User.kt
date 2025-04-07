package com.example.kotlinunlimited.kotlinUnlimitedTasks.oop

class User(
    val name: String,
    val email: String,
    val password: String,
    val isAdmin: Boolean
) {
    var isLoggedIn: Boolean = false
    var age: Int = 0
        get() {return field}
        set(value) {
            if (value < 0) {
                field = 0
                println("Age cannot be negative and set to 0")
            } else {
                field = value
                println("Age set to $value")
            }

        }

    init {
        println("User created: $name")
    }

    fun login() {
        println("User logged in: $name")
    }

}