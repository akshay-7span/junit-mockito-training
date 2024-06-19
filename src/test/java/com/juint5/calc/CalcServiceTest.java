package com.juint5.calc;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
class CalcServiceTest {

    @Test
        // This test method verifies the behavior of the calc method in CalcService
        // It mocks the behavior of the AddService and verifies if the calc method returns the expected result
    void testCalc() {

        // Create a mock for the AddService interface
        AddService addService;
        // Create an instance of CalcService and inject the mocked AddService
        CalcService calcService;

        // Create a mock for the AddService interface using Mockito
        addService = Mockito.mock(AddService.class);
        // Create an instance of CalcService and inject the mocked AddService
        calcService = new CalcService(addService);

        // Define input values and expected result
        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        // Define the behavior of the mocked addService.add() method
        // When addService.add(num1, num2) is called, it will return the expected value
        when(addService.add(num1, num2)).thenReturn(expected);

        // Call the calc method of calcService with the input values
        int actual = calcService.calc(num1, num2);

        // Verify if the actual result matches the expected result
        assertEquals(expected, actual);
    }
}