package com.juint5.assertions;
import org.junit.jupiter.api.*;

// Test class for assertNull and assertNotNull
public class AssertNullNotNullTest {

    // Test method using assertNull
    @Test
    @DisplayName("Test with assertNull")
    public void testWithNull() {
        String nullString = null;
        // assertNull: Checks that the actual value is null
        Assertions.assertNull(nullString, "The string should be null");
    }

    // Test method using assertNotNull
    @Test
    @DisplayName("Test with assertNotNull")
    public void testWithNotNull() {
        String notNullString = "Hello";
        // assertNotNull: Checks that the actual value is not null
        Assertions.assertNotNull(notNullString, "The string should not be null");
    }
}
