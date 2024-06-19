package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CallsMethodVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserCalledInOrder() {
        // Create mock users
        User user1 = new User(1L, "Anup Panchal");
        User user2 = new User(2L, "Harsh Shiyani");

        // Perform save operations
        userService.saveUser(user1); // First invocation with user1
        userService.saveUser(user2); // Second invocation with user2
        userService.saveUser(user1); // Third invocation with user1 again

        // Create inOrder object passing any mocks that need to be verified in order
        InOrder inOrder = inOrder(mockUserRepository);

        // Verify the order of method invocations
        inOrder.verify(mockUserRepository).save(user1); // First save of user1
        inOrder.verify(mockUserRepository).save(user2); // Then save of user2
        inOrder.verify(mockUserRepository).save(user1); // Finally save of user1 again
    }
}
