package com.juint5.assertion;

public class AssertionExample {
    public static void main(String[] args) {
        int age = -5;
        assert age >= 0 : "Age cannot be negative: " + age;
        System.out.println("Age is " + age);
    }
}