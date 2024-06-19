package com.juint5.calc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VerifyInteractionTest {

    @Test
    // This test method demonstrates the usage of verify() method in Mockito framework
    public void testMethod() {
        // Create a mock object of List interface
        List<String> mockedList = Mockito.mock(List.class);

        // Perform some method calls on the mock object
        mockedList.add("first-element");
        mockedList.add("second-element");
        mockedList.add("third-element");
        mockedList.add("third-element");
        mockedList.clear();

        // Verify that certain methods are called with specific parameters
        verify(mockedList).add("first-element");
        verify(mockedList).add("second-element");

        // Verify the number of invocations for a specific method call
        verify(mockedList, times(2)).add("third-element");

        // Verify that a certain method is called
        verify(mockedList).clear();
    }
}

