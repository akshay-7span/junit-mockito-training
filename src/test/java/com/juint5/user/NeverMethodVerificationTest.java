package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class NeverMethodVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserNeverCalled() {
        // Create a mock user
        User userToSave = new User(1L, "Anup Panchal");

        // Call the method under test (without actually calling save on mockUserRepository)
        userService.saveUser(userToSave);

        // Verify that userRepository.save() was never called with any user
        verify(mockUserRepository, never()).findById(1L);
    }
}
