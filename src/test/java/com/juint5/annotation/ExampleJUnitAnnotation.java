package com.juint5.annotation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Example JUnit 5 Test Class") // Custom display name for the test class
public class ExampleJUnitAnnotation  {
    @BeforeEach
    void setUp() {
        // Executed before each test method
        System.out.println("Setting up test...");
    }

    @AfterEach
    void tearDown() {
        // Executed after each test method
        System.out.println("Tearing down test...");
    }

    @BeforeAll
    static void beforeAll() {
        // Executed before all test methods
        System.out.println("Executing before all tests...");
    }

    @AfterAll
    static void afterAll() {
        // Executed after all test methods
        System.out.println("Executing after all tests...");
    }

    @Test /*The @Test annotation is used in JUnit to denote that a particular method is a test method.
     In JUnit 5, this annotation is part of the org.junit.jupiter.api package.
     When you mark a method with @Test, it signifies that the method should be executed as a test case.*/
    @DisplayName("Test Addition") // Custom display name for the test method
    void testAddition() {
        // Test logic for addition
        System.out.println("Running test for addition...");
         /*Assertions in programming are statements or conditions that you expect to be true at a particular point in your code. In the context of unit testing,
           assertions are used to verify that the actual results of a test match the expected results */
        Assertions.assertEquals(5, 2 + 3);
    }

    @Test
    @DisplayName("Test Subtraction")
    void testSubtraction() {
        // Test logic for subtraction
        System.out.println("Running test for subtraction...");
        Assertions.assertEquals(2, 5 - 3);
    }

    @Test
    @Disabled("This test is disabled for demonstration purposes") // Disable a specific test method
    void disabledTest() {
        // Test logic for a disabled test
        System.out.println("This test should be disabled.");
    }

    @Nested
    @DisplayName("Nested Test Cases") // Group related tests in a nested test class
    class NestedTestCases {

        @Test
        @Tag("math")
        void nestedTestMultiplication() {
            // Test logic for multiplication in a nested class
            System.out.println("Running nested test for multiplication...");
            Assertions.assertEquals(15, 3 * 5);
        }

        @Test
        @Tag("math")
        void nestedTestDivision() {
            // Test logic for division in a nested class
            System.out.println("Running nested test for division...");
            Assertions.assertEquals(2, 10 / 5);
        }
    }

}
