package com.juint5.annotation;

import com.juint5.testing.SimpleMath;
import org.junit.jupiter.api.*;

// Main test class
public class SimpleMathTest {

    // BeforeAll: Run this method once before all test methods
    @BeforeAll
    public static void setupClass() {
        System.out.println("Setting up the test class.");
    }

    // AfterAll: Run this method once after all test methods
    @AfterAll
    public static void teardownClass() {
        System.out.println("Tearing down the test class.");
    }

    // BeforeEach: Run this method before each test method
    @BeforeEach
    public void setup() {
        System.out.println("Setting up for the test.");
    }

    // AfterEach: Run this method after each test method
    @AfterEach
    public void teardown() {
        System.out.println("Tearing down after the test.");
    }

    // Test method with DisplayName and Tag annotations
    @Test/*The @Test annotation is used in JUnit to denote that a particular method is a test method.
     In JUnit 5, this annotation is part of the org.junit.jupiter.api package.
     When you mark a method with @Test, it signifies that the method should be executed as a test case.*/
    @DisplayName("Test Addition")
    @Tag("Math")
    public void testAddition() {
        SimpleMath simpleMath = new SimpleMath();
        int result = simpleMath.add(3, 5);
        // Assertion
        Assertions.assertEquals(8, result, "Addition test failed.");
    }

    // Test method with DisplayName and Tag annotations
    @Test
    @DisplayName("Test Subtraction")
    @Tag("Math")
    public void testSubtraction() {
        SimpleMath simpleMath = new SimpleMath();
        int result = simpleMath.subtract(10, 4);
        // Assertion
        Assertions.assertEquals(6, result, "Subtraction test failed.");
    }

    // Test method with Disable annotation
    @Test
    @Disabled("Not implemented yet")
    public void disabledTest() {
        // This test will be skipped
    }

    // Nested test class with BeforeEach and AfterEach annotations
    @Nested
    @DisplayName("Nested Math Operations")
    class NestedMathOperations {

        // BeforeEach: Run this method before each nested test method
        @BeforeEach
        void setupNested() {
            System.out.println("Setting up for nested tests.");
        }

        // AfterEach: Run this method after each nested test method
        @AfterEach
        void teardownNested() {
            System.out.println("Tearing down after nested tests.");
        }

        // Nested test method
        @Test
        @DisplayName("Nested Addition")
        void nestedAddition() {
            SimpleMath simpleMath = new SimpleMath();
            int result = simpleMath.add(2, 3);
            // Assertion
            Assertions.assertEquals(5, result, "Nested Addition test failed.");
        }
    }
}
