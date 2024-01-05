package com.juint5.assertions;

import org.junit.jupiter.api.*;

// Test class for assertThrows
public class AssertThrowsTest {

    // Test method using assertThrows
    @Test
    @DisplayName("Test with assertThrows")
    public void testWithThrows() {
        // assertThrows: Checks that the specified exception is thrown
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0; // This should throw ArithmeticException
        });
    }
}
