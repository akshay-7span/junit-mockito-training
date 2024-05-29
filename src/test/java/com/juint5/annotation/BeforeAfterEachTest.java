package com.juint5.annotation;

import org.junit.jupiter.api.*;

// Test class for BeforeEach and AfterEach annotations
public class BeforeAfterEachTest {

    // BeforeEach: Run this method before each test method
    @BeforeEach
    public void setup() {
        System.out.println("Setting up for the test.");
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

    // AfterEach: Run this method after each test method
    @AfterEach
    public void teardown() {
        System.out.println("Tearing down after the test.");
    }
}
