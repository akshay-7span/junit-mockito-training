package com.juint5.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CalcServiceMockAnnotationTest {

    // The class under test
    CalcService calcService;

    // Mocked dependency
    @Mock
    AddService addService;

    // This method is executed before each test method
    @BeforeEach
    public void setup() {
        // Initialize the mocked dependencies
        MockitoAnnotations.initMocks(this);
        // Instantiate the class under test with the mocked dependencies
        calcService = new CalcService(addService);
    }

    // Test method to verify the behavior of the calc() method
    @Test
    public void testCalc() {
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
