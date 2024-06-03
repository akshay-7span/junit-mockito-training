package com.juint5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitAssertionsExample {
    @Test
    void testAssertEquals() {
        // assertEquals: Compares two strings for equality
        String expectedString = "Hello, JUnit!";
        String actualString = "Hello, JUnit!";
        assertEquals(expectedString, actualString, "Strings should be equal");
    }

    @Test
    void testAssertTrueFalse() {
        // assertTrue / assertFalse: Checks boolean conditions
        assertTrue(5 > 3, "5 is greater than 3");
        assertFalse(2 == 1, "2 is not equal to 1");
    }

    @Test
    void testAssertNullNotNull() {
        // assertNull / assertNotNull: Verifies if a string is null or not null
        String nullString = null;
        assertNull(nullString, "The string should be null");

        String nonNullString = "JUnit";
        assertNotNull(nonNullString, "The string should not be null");
    }

    @Test
    void testAssertArrayEquals() {
        // assertArrayEquals: Compares two arrays for equality
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray, "Arrays should be equal");
    }

    @Test
    void testAssertThrows() {
        // assertThrows: Checks if executing a specific code block throws an expected exception
        assertThrows(ArithmeticException.class, () -> divide(5, 0), "Division by zero should throw ArithmeticException");
    }

    // Helper method for assertThrows example
    private int divide(int dividend, int divisor) {
        return dividend / divisor;
    }
}
