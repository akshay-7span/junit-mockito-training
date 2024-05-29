package com.juint5.assertions;

import org.junit.jupiter.api.*;

// Test class for assertEquals
public class AssertEqualsTest {

    @Test
    @DisplayName("Test with assertEquals")
    public void testWithEquals() {
        int actualResult = 10 + 5;
        // assertEquals: Checks that the actual value is equal to the expected value
        Assertions.assertEquals(15, actualResult, "Adding 10 and 5 should equal 15");
    }
}