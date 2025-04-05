package com.example.kotlinunlimited.kotlinUnlimitedTasks.sudokuChecker


import com.example.kotlinunlimited.kotlinUnlimitedTasks.sudokuChecker.IPv4Checker.isValidIPv4
import org.junit.Assert.*
import org.junit.Test

/**
 * - IPv4 Checker Test Cases:
 * - isValidIPv4_GivenValidAddresses_ShouldReturnTrue
 * - isValidIPv4_GivenInvalidAddressesWithLeadingZeros_ShouldReturnFalse
 * - isValidIPv4_GivenInvalidAddressesWithOutOfRangeNumbers_ShouldReturnFalse
 * - isValidIPv4_GivenInvalidAddressesWithWrongFormat_ShouldReturnFalse
 * - isValidIPv4_GivenInvalidAddressesWithEmptyOrNull_ShouldReturnFalse
 * - isValidIPv4_GivenInvalidSegmentCount_ShouldReturnFalse
 */

class IPv4CheckerTest {

    @Test
    fun isValidIPv4_GivenValidAddresses_ShouldReturnTrue() {
        assertTrue(isValidIPv4("192.168.1.1"))
        assertTrue(isValidIPv4("0.0.0.0"))
        assertTrue(isValidIPv4("255.255.255.255"))
        assertTrue(isValidIPv4("172.16.0.1"))
    }

    @Test
    fun isValidIPv4_GivenInvalidAddressesWithLeadingZeros_ShouldReturnFalse() {
        assertFalse(isValidIPv4("192.168.001.1"))
        assertFalse(isValidIPv4("01.1.1.1"))
        assertFalse(isValidIPv4("00.0.0.0"))
    }

    @Test
    fun isValidIPv4_GivenInvalidAddressesWithOutOfRangeNumbers_ShouldReturnFalse() {
        assertFalse(isValidIPv4("256.100.100.100"))
        assertFalse(isValidIPv4("192.168.1.999"))
        assertFalse(isValidIPv4("300.300.300.300"))
    }

    @Test
    fun isValidIPv4_GivenInvalidAddressesWithWrongFormat_ShouldReturnFalse() {
        assertFalse(isValidIPv4("192.168.1"))
        assertFalse(isValidIPv4("192.168.1.1.1"))
        assertFalse(isValidIPv4("192,168,1,1"))
        assertFalse(isValidIPv4("abc.def.ghi.jkl"))
        assertFalse(isValidIPv4("..."))
        assertFalse(isValidIPv4("192.168.1.one"))
    }

    @Test
    fun isValidIPv4_GivenInvalidAddressesWithEmptyOrNull_ShouldReturnFalse() {
        assertFalse(isValidIPv4(""))
        assertFalse(isValidIPv4(" "))
        assertFalse(isValidIPv4("   "))
    }

    @Test
    fun isValidIPv4_GivenInvalidSegmentCount_ShouldReturnFalse() {
        assertFalse(isValidIPv4("192.168.1"))     // Only 3 segments
        assertFalse(isValidIPv4("192.168.1.1.5")) // 5 segments
    }

}