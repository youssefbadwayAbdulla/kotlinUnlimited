package com.example.kotlinunlimited.kotlinUnlimitedTasks.generic

fun main() {
    val fleetManager = FleetManager<Bike>()
    val vehicle = Bike(
        id = 1,
        brand = "Toyota",
        model = "2022",
        year = 2022,
        color = "Red",
        price = 20000.0,
        capacity = 5
    )
    fleetManager.add(vehicle)
    fleetManager.getVehicles().forEach { println(it) }
}