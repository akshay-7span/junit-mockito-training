package com.juint5.annotation;
import org.junit.jupiter.api.*;

// Test class for BeforeAll and AfterAll annotations
public class BeforeAfterAllTest {

    // BeforeAll: Run this method once before all test methods
    @BeforeAll
    public static void setupClass() {
        System.out.println("Setting up the test class.");
    }

    // Test method
    @Test
    @DisplayName("Test 1")
    public void test1() {
        System.out.println("Test 1 executed.");
    }

    // Test method
    @Test
    @DisplayName("Test 2")
    public void test2() {
        System.out.println("Test 2 executed.");
    }

    // AfterAll: Run this method once after all test methods
    @AfterAll
    public static void teardownClass() {
        System.out.println("Tearing down the test class.");
    }
}