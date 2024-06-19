package com.juint5.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("UserService Tests")
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test getUserById")
    void testGetUserById() {
        // Define mock behavior
        User mockUser = new User(1L, "Anup Panchal");
        when(mockUserRepository.findById(1L)).thenReturn(mockUser);

        // Call the method under test
        User result = userService.getUserById(1L);

        // Verify the result
        Assertions.assertEquals("Anup Panchal", result.getName());
    }

    @Test
    @DisplayName("Test saveUser")
    void testSaveUser() {
        // Create a mock user
        User userToSave = new User(2L, "Anup Panchal");

        // Call the method under test
        userService.saveUser(userToSave);

        // Verify that userRepository.save() was called with the correct argument
        verify(mockUserRepository, times(1)).save(userToSave);
    }
}