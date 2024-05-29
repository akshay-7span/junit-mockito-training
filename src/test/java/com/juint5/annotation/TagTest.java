package com.juint5.annotation;

import com.juint5.testing.SimpleMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

// Test class for Tag annotation
public class TagTest {
    @Test
    @DisplayName("Test Subtraction")
    @Tag("Math")
    public void testSubtraction() {
        SimpleMath simpleMath = new SimpleMath();
        int result = simpleMath.subtract(10, 4);
        // Assertion
        Assertions.assertEquals(6, result, "Subtraction test failed.");
    }
}