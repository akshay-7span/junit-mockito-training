package com.juint5.calc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockSingleElementTest {

    // This test method demonstrates stubbing a concrete/implementation class using Mockito
    @Test
    public void testMethod() {
        // Create a mock object of ArrayList class
        ArrayList mockedList = mock(ArrayList.class);

        // Stub the behavior of the get() method
        when(mockedList.get(0)).thenReturn("first-element");

        // Print the value retrieved from the mock object and verify it
        System.out.println(mockedList.get(0));
        assertEquals("first-element", mockedList.get(0));

        // Print the value retrieved from the mock object, which will be "null" as get(1) is not stubbed
        System.out.println(mockedList.get(1));
    }
}
