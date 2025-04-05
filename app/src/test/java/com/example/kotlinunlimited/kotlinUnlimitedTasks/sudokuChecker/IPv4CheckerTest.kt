package com.example.kotlinunlimited.kotlinUnlimitedTasks.sudokuChecker

import com.example.kotlinunlimited.kotlinUnlimitedTasks.sudokuChecker.IPv4Checker.isValidIPv4
import org.junit.Assert.*
import org.junit.Test

class IPv4CheckerTest {

    @Test
    fun testValidIPv4Addresses() {
        assertTrue(isValidIPv4("192.168.1.1"))
        assertTrue(isValidIPv4("0.0.0.0"))
        assertTrue(isValidIPv4("255.255.255.255"))
        assertTrue(isValidIPv4("172.16.0.1"))
    }


    @Test
    fun testInvalidIPv4AddressesWithLeadingZeros() {
        assertFalse(isValidIPv4("192.168.001.1"))
        assertFalse(isValidIPv4("01.1.1.1"))
        assertFalse(isValidIPv4("00.0.0.0"))
    }

    @Test
    fun testInvalidIPv4AddressesWithOutOfRangeNumbers() {
        assertFalse(isValidIPv4("256.100.100.100"))
        assertFalse(isValidIPv4("192.168.1.999"))
        assertFalse(isValidIPv4("300.300.300.300"))
    }

    @Test
    fun testInvalidIPv4AddressesWithWrongFormat() {
        assertFalse(isValidIPv4("192.168.1"))
        assertFalse(isValidIPv4("192.168.1.1.1"))
        assertFalse(isValidIPv4("192,168,1,1"))
        assertFalse(isValidIPv4("abc.def.ghi.jkl"))
        assertFalse(isValidIPv4("..."))
        assertFalse(isValidIPv4("192.168.1.one"))
    }

    @Test
    fun testInvalidIPv4AddressesWithEmptyOrNull() {
        assertFalse(isValidIPv4(""))
        assertFalse(isValidIPv4(" "))
        assertFalse(isValidIPv4("   "))
    }

    @Test
    fun testInvalidSegmentCount() {
        assertFalse(isValidIPv4("192.168.1"))     // Only 3 segments
        assertFalse(isValidIPv4("192.168.1.1.5")) // 5 segments
    }

}
