package com.juint5.testing;

public class SimpleMathTest {

    public static void main(String[] args) {
        // Test the add method
        testAddition();

        // Test the subtract method
        testSubtraction();
    }

    private static void testAddition() {
        SimpleMath simpleMath = new SimpleMath();
        int result = simpleMath.add(3, 5);
        if (result == 8) {
            System.out.println("Addition test passed.");
        } else {
            System.out.println("Addition test failed. Expected 8, but got: " + result);
        }
    }

    private static void testSubtraction() {
        SimpleMath simpleMath = new SimpleMath();
        int result = simpleMath.subtract(10, 4);
        if (result == 6) {
            System.out.println("Subtraction test passed.");
        } else {
            System.out.println("Subtraction test failed. Expected 6, but got: " + result);
        }
    }
}

class SimpleMath {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
