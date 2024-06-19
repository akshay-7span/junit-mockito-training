package com.juint5.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidateMockitoUsageTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void testSaveUser() {
        // Create a mock user
        User user = new User(1L, "Anup Panchal");

        // Perform the save operation
        userService.saveUser(user);

        // Verify that userRepository.save(user) was called
        verify(mockUserRepository).save(user);

        // Explicitly validate Mockito usage
        validateMockitoUsage();
    }

    @Test
    void testGetUserById() {
        // Create a mock user
        User user = new User(1L, "Anup Panchal");
        when(mockUserRepository.findById(1L)).thenReturn(user);

        // Perform the get operation
        User result = userService.getUserById(1L);

        // Verify that userRepository.findById(1L) was called and the result is as expected
        verify(mockUserRepository).findById(1L);
        assertEquals(user, result);

        // Explicitly validate Mockito usage
        validateMockitoUsage();
    }
}
