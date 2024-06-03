package com.juint5.assertions;

import org.junit.jupiter.api.*;

// Test class for assertArrayEquals
public class AssertArrayEqualsTest {

    @Test
    @DisplayName("Test with assertArrayEquals")
    public void testArrayEquals() {
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        // assertArrayEquals: Checks that the arrays are equal
        Assertions.assertArrayEquals(expectedArray, actualArray, "Arrays should be equal");
    }
}