package com.juint5.assertions;

import org.junit.jupiter.api.*;

// Test class for assertFalse
public class AssertFalseTest {

    // Test method using assertFalse
    @Test
    @DisplayName("Test with assertFalse")
    public void testWithFalse() {
        boolean condition = false;
        // assertFalse: Checks that the condition is false
        Assertions.assertFalse(condition, "The condition should be false");
    }
}
