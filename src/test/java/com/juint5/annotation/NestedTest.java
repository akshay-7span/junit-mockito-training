package com.juint5.annotation;

import org.junit.jupiter.api.*;

// Test class for Nested annotation
public class NestedTest {

    // Nested test class
    @Nested
    @DisplayName("Nested Tests")
    class NestedTests {

        // Test method inside nested class
        @Test
        @DisplayName("Nested Test 1")
        void nestedTest1() {
            System.out.println("Nested Test 1 executed.");
        }

        // Test method inside nested class
        @Test
        @DisplayName("Nested Test 2")
        void nestedTest2() {
            System.out.println("Nested Test 2 executed.");
        }
    }
}
