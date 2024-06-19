package com.juint5.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Configures Spring Boot to provide only web layer components for testing.
@WebMvcTest(UserController.class)
// Integrates Mockito with JUnit 5, allowing for the use of @Mock and @InjectMocks annotations.
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    // Injects the MockMvc instance, which provides support for testing MVC controllers by performing HTTP requests and verifying responses.
    @Autowired
    private MockMvc mockMvc;

    // Adds a Mockito mock to the Spring application context. This is used to mock the UserService bean, allowing for control over its behavior in tests.
    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        // Set up MockMvc with the UserController
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    @Test
    void testGetUserById_Success() throws Exception {
        // Purpose: Tests the getUserById method to ensure it returns the correct user and HTTP status when the user exists.
        // Setup: Mocks the UserService to return a User object when getUserById is called with an ID of 1.
        User user = new User(1L, "Anup Panchal");
        when(userService.getUserById(1L)).thenReturn(user);

        // Expected JSON response
        String expectedJson = "{\"id\":1,\"name\":\"Anup Panchal\"}";

        // Execution: Performs a GET request to /users/1 and verifies the response status is 200 OK and the returned JSON matches the expected user data.
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
        // Verification: Ensures the getUserById method of UserService is called with the correct ID.
        verify(userService).getUserById(1L);
    }

    @Test
    void testGetUserById_NotFound() throws Exception {
        // Purpose: Tests the getUserById method to ensure it returns a 404 Not Found status when the user does not exist.
        // Setup: Mocks the UserService to return null when getUserById is called with an ID of 1.
        when(userService.getUserById(1L)).thenReturn(null);

        // Execution: Performs a GET request to /users/1 and verifies the response status is 404 Not Found.
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isNotFound());

        // Verification: Ensures the getUserById method of UserService is called with the correct ID.
        verify(userService).getUserById(1L);
    }

    @Test
    void testSaveUser_Success() throws Exception {
        // Purpose: Tests the saveUser method to ensure it saves the user and returns the correct HTTP status.
        // Setup: Mocks the UserService and configures the test to perform a POST request with user data in the request body.

        // Execution: Performs a POST request to /users with user JSON data and verifies the response status is 201 Created.
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Anup Panchal\"}"))
                .andExpect(status().isCreated());

        // Verification: Ensures the saveUser method of UserService is called with the correct user data.
        verify(userService).saveUser(any(User.class));
    }
}