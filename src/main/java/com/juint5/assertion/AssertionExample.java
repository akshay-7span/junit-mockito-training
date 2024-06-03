package com.juint5.assertion;

public class AssertionExample {

    public static void main(String[] args) {
        // Enable assertions using the -ea flag when running the program
        // Example: java -ea AssertionExample

        // Example of a simple assertion
        int result = factorial(5);
        System.out.println("Factorial of 5 is: " + result);

        // Example of an assertion with a detail message
        // This will trigger an assertion error with a message
        result = factorialWithMessage(-1);
    }

    /**
     * Calculates the factorial of a non-negative integer using a simple assertion.
     * @param n the non-negative integer
     * @return the factorial of the integer
     * @throws AssertionError if n is negative
     */
    public static int factorial(int n) {
        // Simple assertion: checks if n is non-negative
        assert n >= 0; // Will throw AssertionError if n < 0

        // Basic factorial calculation
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculates the factorial of a non-negative integer using an assertion with a detail message.
     * @param n the non-negative integer
     * @return the factorial of the integer
     * @throws AssertionError if n is negative with a detailed message
     */
    public static int factorialWithMessage(int n) {
        // Assertion with a detail message: provides an error message if n is negative
        assert n >= 0 : "The input number must be non-negative";

        // Basic factorial calculation
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

