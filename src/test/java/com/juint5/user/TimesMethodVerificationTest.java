package com.juint5.user;
import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;

public class TimesMethodVerificationTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        // Create a mock user
        User userToSave = new User(1L, "Anup panchal");

        // Call the method under test
        userService.saveUser(userToSave);

        // Verify that userRepository.save() was called exactly once with userToSave
        verify(mockUserRepository, times(1)).save(userToSave);
    }

    @Test
    void testSaveUserMultipleTimes() {
        // Create mock users
        User user1 = new User(1L, "Anup panchal");
        User user2 = new User(2L, "Anup panchal");

        // Call the method under test multiple times
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user1);

        // Verify that userRepository.save() was called exactly twice with user1 and once with user2
        verify(mockUserRepository, times(2)).save(user1);
        verify(mockUserRepository, times(1)).save(user2);
    }
}
