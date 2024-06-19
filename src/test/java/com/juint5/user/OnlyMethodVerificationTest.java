package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.ArgumentsAreDifferent;
import org.mockito.exceptions.verification.VerificationInOrderFailure;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

public class OnlyMethodVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserCalledOnceAndOnly() {
        // Create a mock user
        User user = new User(1L, "John Doe");

        // Perform the save operation
        userService.saveUser(user);

        // Verify that userRepository.save(user) is the only method called exactly once
        verify(mockUserRepository, only()).save(user);
    }
    
}