package com.juint5.calc;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class CalcServiceInOrderTest {

    @Test
    public void testCalcInOrder() {
        // Create a mock of AddService
        AddService addService = mock(AddService.class);

        // Create an instance of CalcService with the mocked AddService
        CalcService calcService = new CalcService(addService);

        // Define the numbers to be added
        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        // Stub the add() method to return the expected value
        when(addService.add(num1, num2)).thenReturn(expected);

        // Call the calc() method twice to create interactions with the mock
        calcService.calc(num1, num2);
        calcService.calc(num1, num2);

        // Verify that add() was called twice in total
        verify(addService, times(2)).add(num1, num2);

        // Create an inOrder verifier for the addService mock
        InOrder inOrder = inOrder(addService);

        // Verify that add() was called twice in the exact order
        inOrder.verify(addService, times(2)).add(num1, num2);
    }
}