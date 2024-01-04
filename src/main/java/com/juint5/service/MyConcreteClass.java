package com.juint5.service;

public class MyConcreteClass {
    private String data;

    // Constructor
    public MyConcreteClass(String data) {
        this.data = data;
    }

    // A method to be mocked or stubbed
    public String myMethod() {
        return "Actual Implementation: " + data;
    }

    // Another method to be mocked or stubbed
    public int calculate(int a, int b) {
        return a + b;
    }
}
