package com.juint5.assertions;

import org.junit.jupiter.api.*;

// Test class for assertAll
public class AssertAllTest {

    // Test method using assertAll
    @Test
    @DisplayName("Test with assertAll")
    public void testWithAll() {
        // assertAll: Groups multiple assertions and fails if any of them fail
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, 1 + 1, "Addition failed"),
                () -> Assertions.assertTrue(3 > 1, "Comparison failed"),
                () -> Assertions.assertFalse(false, "False condition failed")
        );
    }
}
