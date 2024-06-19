package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfterVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testSaveUserCalledAfter() {
        // Create a mock user
        User user = new User(1L, "Anup Panchal");

        // Perform the save operation asynchronously
        CompletableFuture<Void> future = userService.saveUserAsync(user);

        // Ensure the asynchronous operation has time to complete
        future.join();

        // Verify that userRepository.save(user) is called after 1000 milliseconds
        verify(mockUserRepository, after(1000)).save(user);
    }
}
