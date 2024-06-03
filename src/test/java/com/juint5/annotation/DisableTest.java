package com.juint5.annotation;

import org.junit.jupiter.api.*;

// Test class for Disable annotation
public class DisableTest {

    // Test method with Disable annotation
    @Test
    @Disabled("This test is disabled for a reason.")
    public void disabledTest() {
        System.out.println("This test should be disabled and not executed.");
    }

    // Test method without Disable annotation
    @Test
    public void enabledTest() {
        System.out.println("This test should be enabled and executed.");
    }
}
