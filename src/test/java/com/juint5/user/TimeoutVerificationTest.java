package com.juint5.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TimeoutVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void testSaveUserCalledWithTimeout() {
        // Create a mock user
        User user = new User(1L, "Anup Panchal");

        // Perform the save operation asynchronously
        userService.saveUserAsync(user);

        // Verify that userRepository.save(user) is called within 1000 milliseconds
        verify(mockUserRepository, timeout(1000)).save(user);
    }
}