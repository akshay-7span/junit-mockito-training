package com.juint5.calc;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
public class CalcServiceDoTrowTest {


    /**
     * This test method demonstrates the usage of doThrow() with a Throwable instance.
     * It stubs the add() method to throw a RuntimeException when called with the arguments 11 and 12.
     */
    @Test
    public void testCalcWithThrowable() {
        // Create a mock of AddService
        AddService addService = mock(AddService.class);

        // Create an instance of CalcService with the mocked AddService
        CalcService calcService = new CalcService(addService);

        // Stub the add() method to throw a specific exception
        doThrow(new RuntimeException("Runtime exception")).when(addService).add(11, 12);

        // Verify that the calc() method throws the expected exception when add() is called
        assertThrows(RuntimeException.class, () -> calcService.calc(11, 12));
    }

    /**
     * This test method demonstrates the usage of doThrow() with a Class<? extends Throwable>.
     * It stubs the add() method to throw a RuntimeException when called with the arguments 11 and 12.
     */
    @Test
    public void testCalcWithClass() {
        // Create a mock of AddService
        AddService addService = mock(AddService.class);

        // Create an instance of CalcService with the mocked AddService
        CalcService calcService = new CalcService(addService);

        // Stub the add() method to throw a specific exception class
        doThrow(RuntimeException.class).when(addService).add(11, 12);

        // Verify that the calc() method throws the expected exception when add() is called
        assertThrows(RuntimeException.class, () -> calcService.calc(11, 12));
    }
}
