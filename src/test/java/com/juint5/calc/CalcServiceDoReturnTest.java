package com.juint5.calc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
public class CalcServiceDoReturnTest {

    /**
     * This test method demonstrates the usage of Mockito doReturn() method.
     * It stubs the add() method of AddService to return a specific value when called with given arguments.
     */
    @Test
    public void testCalcUsingDoReturn() {
        // Create a mock of AddService
        AddService addService = mock(AddService.class);

        // Create an instance of CalcService with the mocked AddService
        CalcService calcService = new CalcService(addService);

        // Define the numbers to be added
        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        // Use doReturn() to stub the add() method to return the expected value
        doReturn(expected).when(addService).add(num1, num2);

        // Call the calc() method and verify that it returns the expected value
        int actual = calcService.calc(num1, num2);
        assertEquals(expected, actual);
    }
}
