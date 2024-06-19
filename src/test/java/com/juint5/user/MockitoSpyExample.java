package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoSpyExample {

    private UserRepository mockUserRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        mockUserRepository = mock(UserRepository.class);
        userService = spy(new UserService(mockUserRepository));
    }

    @Test
    public void testSaveUserAsync() throws InterruptedException, ExecutionException {
        // Create a user object
        User user = new User(1L, "John Doe");

        // Simulate saving user asynchronously
        CompletableFuture<Void> future = userService.saveUserAsync(user);

        // Wait for completion of the asynchronous task
        future.get();

        // Verify that userRepository.save(user) was called exactly once
        verify(mockUserRepository, times(1)).save(user);

        // Stub the findById method to return a User object
        when(mockUserRepository.findById(1L)).thenReturn(new User(1L, "John Doe"));

        // Call getUserById method
        User savedUser = userService.getUserById(1L);

        // Assert that the user was saved correctly
        assertEquals("John Doe", savedUser.getName());
    }

    @Test
    public void testGetUserById() {
        // Stubbing findById method of mockUserRepository
        when(mockUserRepository.findById(1L)).thenReturn(new User(1L, "Jane Smith"));

        // Call getUserById method
        User user = userService.getUserById(1L);

        // Verify the result
        assertEquals("Jane Smith", user.getName());

        // Verify that userRepository.findById(1L) was called exactly once
        verify(mockUserRepository, times(1)).findById(1L);
    }
}
