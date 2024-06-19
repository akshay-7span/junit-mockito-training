package com.juint5.calc;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TestMockitoIgnoreStubs {

    @Test
    public void testCalculation() {
        // Create a mock AddService
        AddService addService = mock(AddService.class);

        // Create an instance of CalcService with the mock AddService
        CalcService calcService = new CalcService(addService);

        // Stubbing the add method of AddService
        when(addService.add(5, 7)).thenReturn(12);

        // Test the calc method of CalcService
        int result = calcService.calc(5, 7);

        // Verify that the add method of AddService was called with specific arguments
        verify(addService).add(5, 7);

        // Verify that there are no more interactions with the mock AddService
        verifyNoMoreInteractions(ignoreStubs(addService));

        // Verify the result
        assert result == 12 : "Calculation test failed";
    }
}