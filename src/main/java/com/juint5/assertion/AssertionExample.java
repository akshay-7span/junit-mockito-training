package com.juint5.assertion;

public class AssertionExample {

    public static void main(String[] args) {
        // Enable assertions using -ea flag when running the program
        // Example: java -ea AssertionExample

        int result = factorial(5);
        System.out.println("Factorial of 5 is: " + result);

        // This will trigger an assertion error
        result = factorial(-1);
    }

    public static int factorial(int n) {
        assert n >= 0 : "The input number must be non-negative";
        // Basic factorial calculation
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
