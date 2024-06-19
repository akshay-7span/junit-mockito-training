package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AtMostMethodVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserAtMostOnce() {
        // Create a mock user
        User userToSave = new User(1L, "Anup Panchal");

        // Call the method under test twice
        userService.saveUser(userToSave);
        userService.saveUser(userToSave);

        // Verify that userRepository.save() was called at most 2 times
        verify(mockUserRepository, atMost(2)).save(any());
    }

    @Test
    void testFindUserAtMostOnce() {
        // Call the method under test once
        userService.getUserById(1L);

        // Verify that userRepository.findById() was called at most 1 time
        verify(mockUserRepository, atMost(1)).findById(anyLong());
    }
}
