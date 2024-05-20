package com.juint5.assumption;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsExample {
    // Test assumes that 'A' is always equal to 'A', which is true
    @Test
    void testAssumeTrue() {
        boolean b = 'A' == 'A';
        assumeTrue(b); // Assuming that 'A' is equal to 'A'
        assertEquals("Hello", "Hello"); // This assertion will be executed only if the assumption is true
    }

    // Test assumes that the current day is Saturday
    @Test
    @DisplayName("test executes only on Saturday")
    public void testAssumeTrueSaturday() {
        LocalDateTime dt = LocalDateTime.now();
        assumeTrue(dt.getDayOfWeek().getValue() == 6); // Assuming that the current day is Saturday
        System.out.println("Further code will execute only if the above assumption holds true");
    }

    // Test assumes that 'A' is not equal to 'A', which is false
    @Test
    void testAssumeFalse() {
        boolean b = 'A' != 'A';
        assumeFalse(b); // Assuming that 'A' is not equal to 'A' (which is false)
        assertEquals("Hello", "Hello"); // This assertion will be executed only if the assumption is false
    }

    // Test assumes that the system property 'env' is not equal to "dev"
    @Test
    void testAssumeFalseEnvProp() {
        System.setProperty("env", "prod");
        assumeFalse("dev".equals(System.getProperty("env"))); // Assuming that the system property 'env' is not "dev"
        System.out.println("Further code will execute only if the above assumption holds true");
    }

    // Test assumes that the system property 'env' is equal to "test"
    @Test
    void testAssumingThat() {
        System.setProperty("env", "test");
        assumingThat("test".equals(System.getProperty("env")), () -> {
            assertEquals(10, 10);
            System.out.println("Perform below assertions only on the test env");
        });

        assertEquals(20, 20);
        System.out.println("Perform below assertions on all environments");
    }
}
