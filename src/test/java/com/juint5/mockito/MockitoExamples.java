package com.juint5.mockito;

import com.juint5.service.MyConcreteClass;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.ignoreStubs;

public class MockitoExamples {


    // Mockito mock() Method
    @Test
    public void testMockitoMockMethod() {
        // Creating a mock object for List interface
        List<String> mockedList = mock(List.class);

        // Behavior Verification
        when(mockedList.size()).thenReturn(10);

        // Invoke the size() method (added this line)
        int size = mockedList.size();

        // Verify Interaction
        verify(mockedList, times(1)).size(); // Adjust the times(4) here

        // Now you can use 'size' in your assertions if needed
        assertEquals(10, size);
    }

    // Mockito Stub Concrete Class
    @Test
    public void testMockitoStubConcreteClass() {
        // Mocking a concrete class
        MyConcreteClass myMock = mock(MyConcreteClass.class);

        // Behavior Verification
        when(myMock.myMethod()).thenReturn("Mocked");

        // Call myMethod on the mocked object
        String result = myMock.myMethod();
        assertEquals("Mocked",result);
        // Verify that myMethod was called
        verify(myMock).myMethod();

    }

    // Mockito Spy
    @Test
    public void testMockitoSpy() {
        // Creating a spy on a real object (ArrayList)
        List<String> list = Mockito.spy(new ArrayList<>());

        // Behavior Verification
        when(list.size()).thenReturn(10);

        // Call size on the spy object
        int size = list.size();
        assertEquals(10,size);

        // Verify Interaction
        verify(list).size();
    }

    // Mockito doThrow() method
    @Test
    public void testMockitoDoThrowMethod() {
        // Using doThrow() to throw an exception
        List<String> mockedList = mock(List.class);
        Mockito.doThrow(new RuntimeException()).when(mockedList).clear();

        // Verifying the interaction and expecting an exception
        try {
            mockedList.clear();
        } catch (Exception e) {
            // Handle the exception
        }

        verify(mockedList).clear();
    }

    // Mockito doReturn() method
    @Test
    public void testMockitoDoReturnMethod() {
        // Using doReturn() to define the return value
        List<String> mockedList = mock(List.class);
        Mockito.doReturn(10).when(mockedList).size();

        // Verifying the interaction
        int size = mockedList.size();
        assert size == 10;
        verify(mockedList).size();
    }

    // Mockito inOrder() method
    @Test
    public void testMockitoInOrderMethod() {
        // Creating mocks
        List<String> firstMock = mock(List.class);
        List<String> secondMock = mock(List.class);

        // Creating inOrder object passing any mocks that need to be verified in order
        InOrder inOrder = inOrder(firstMock, secondMock);

        // Using mocks
        firstMock.add("one");
        secondMock.add("two");

        // Verifying the order of method calls
        inOrder.verify(firstMock).add("one");
        inOrder.verify(secondMock).add("two");
    }

    // Mockito ignoreStubs() method
    @Test
    public void testMockitoIgnoreStubsMethod() {
        // Creating mocks
        MyConcreteClass mock1 = mock(MyConcreteClass.class);
        MyConcreteClass mock2 = mock(MyConcreteClass.class);

        // Stubbing methods
        when(mock1.calculate(1,2)).thenReturn(3);
        when(mock2.calculate(2,1)).thenReturn(3);


        // Ignore all stubbed methods during verification
        Mockito.verifyNoInteractions(ignoreStubs(mock1, mock2));
    }
    // Mockito times() method
    @Test
    public void testMockitoTimesMethod() {
        // Creating a mock
        List<String> mockedList = mock(List.class);

        // Behavior Verification with specific invocation count
        mockedList.size();
        mockedList.size();
        verify(mockedList, times(2)).size();
    }

    // Mockito never() method
    @Test
    public void testMockitoNeverMethod() {
        // Creating a mock
        List<String> mockedList = mock(List.class);

        // Verifying that a method was never called
        verify(mockedList, Mockito.never()).clear();
    }

    // Mockito atLeastOnce() method
    @Test
    public void testMockitoAtLeastOnceMethod() {
        // Creating a mock
        List<String> mockedList = mock(List.class);

        // Verifying that a method was called at least once
        mockedList.size();
        verify(mockedList, Mockito.atLeastOnce()).size();
    }

    // Mockito atLeast() method
    @Test
    public void testMockitoAtLeastMethod() {
        // Creating a mock
        List<String> mockedList = mock(List.class);

        // Verifying that a method was called at least a specific number of times
        mockedList.size();
        mockedList.size();
        mockedList.size();
        verify(mockedList, Mockito.atLeast(2)).size();
    }

    // Mockito atMost() method
    @Test
    public void testMockitoAtMostMethod() {
        // Creating a mock
        List<String> mockedList = mock(List.class);

        // Verifying that a method was called at most a specific number of times
        mockedList.size();
        mockedList.size();
        verify(mockedList, Mockito.atMost(5)).size();
    }

    // Mockito calls() method
    @Test
    public void testMockitoCallsMethod() {
        // Creating a mock
        List<String> mockedList = mock(List.class);

        // Verifying the exact number of invocations
        mockedList.size();
        mockedList.isEmpty();

        verify(mockedList, times(1)).size();
        verify(mockedList, times(1)).isEmpty();

        // Verify that no other methods were called on the mock
        verifyNoMoreInteractions(mockedList);
    }

    // Mockito only() method
    @Test
    public void testMockitoOnlyMethod() {
        Map mockMap = mock(Map.class);

        // Perform some operations on the mock object
        mockMap.isEmpty();

        // Verifying that only these methods were called and nothing else
        verify(mockMap, only()).isEmpty();
    }

    // Mockito timeout() method
    @Test
    public void testMockitoTimeoutMethod() {

        List<String> mockList = mock(List.class);
        mockList.add("Anup");
        mockList.size();

        // Verifying that a method was called within a specific timeout
        verify(mockList, timeout(1)).size();


    }

    // Mockito after() method (Updated)
    @Test
    public void testMockitoAfterMethod() {
        // Creating mocks
        List<String> firstMock = mock(List.class);
        List<String> secondMock = mock(List.class);

        // Creating inOrder object passing any mocks that need to be verified in order
        InOrder inOrder = inOrder(firstMock, secondMock);

        // Using mocks
        firstMock.size();

        // Verifying the order of method calls
        inOrder.verify(firstMock).size();

        // Waiting for 100 milliseconds (you may adjust the time as needed)
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Continue with the next interaction
        secondMock.add("two");

        // Verifying the order of method calls
        inOrder.verify(secondMock).add("two");
    }

    // Mockito validateMockitoUsage() method
    @Test
    public void testMockitoValidateMockitoUsageMethod() {
        // Validating the correct usage of Mockito
        Mockito.validateMockitoUsage();
    }

    // Argument Matchers
    @Test
    public void testMockitoArgumentMatchers() {
        // Creating a mock
        List<String> mockedList = mock(List.class);

        // Using argument matchers to match any string
        when(mockedList.get(ArgumentMatchers.anyInt())).thenReturn("MockedValue");

        // Verifying the interaction with any integer argument
        assert "MockedValue".equals(mockedList.get(42));
        verify(mockedList).get(ArgumentMatchers.anyInt());
    }
}
