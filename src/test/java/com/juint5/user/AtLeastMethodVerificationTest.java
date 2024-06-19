package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AtLeastMethodVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserAtLeastOnce() {
        // Create a mock user
        User userToSave = new User(1L, "John Doe");

        // Call the method under test multiple times
        userService.saveUser(userToSave);
        userService.saveUser(userToSave);
        userService.saveUser(userToSave);

        // Verify that userRepository.save() was called at least 3 times
        verify(mockUserRepository, atLeast(3)).save(any());
    }

    @Test
    void testFindUserAtLeastOnce() {
        // Call the method under test multiple times
        userService.getUserById(1L);
        userService.getUserById(1L);

        // Verify that userRepository.findById() was called at least 2 times
        verify(mockUserRepository, atLeast(2)).findById(anyLong());
    }
}
