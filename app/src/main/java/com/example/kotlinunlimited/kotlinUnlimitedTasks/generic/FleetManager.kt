package com.example.kotlinunlimited.kotlinUnlimitedTasks.generic

class FleetManager<T : Vehicle> {
    private val vehicles = mutableListOf<T>()
    fun add(vehicle: T) {
        vehicles.add(vehicle)
        println("Vehicle added to fleet: $vehicle")
    }

    fun remove(vehicle: T) {
        if (vehicles.remove(vehicle)) {
            println("Vehicle removed from fleet: $vehicle")
        }else{
            println("Vehicle not found in fleet: $vehicle")
        }
    }

    fun getVehicles(): List<T> {
        return vehicles
    }
}