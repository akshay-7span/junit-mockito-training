package com.juint5.assertions;

import org.junit.jupiter.api.*;

// Test class for assertAll
public class AssertAllTest {

    @Test
    @DisplayName("Test with assertAll")
    public void testWithAll() {
        // assertAll: Groups multiple assertions and fails if any of them fail
        Assertions.assertAll(
                () -> {
                    // assertEquals: Checks that the actual value is equal to the expected value
                    Assertions.assertEquals(2, 1 + 1, "Addition failed");
                },
                () -> {
                    // assertTrue: Checks that the condition is true
                    Assertions.assertTrue(3 > 1, "Comparison failed");
                },
                () -> {
                    // assertFalse: Checks that the condition is false
                    Assertions.assertFalse(false, "False condition failed");
                }
        );
    }
}
