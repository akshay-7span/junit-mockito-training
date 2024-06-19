package com.juint5.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Indicates that this class is a REST controller where each method returns a domain object instead of a view.
@RestController
// Maps HTTP requests to the /users path to the methods in this controller.
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Automatically injects the UserService bean into the UserController.
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Maps HTTP GET requests to the getUserById method, where {id} is a path variable.
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Maps HTTP POST requests to the saveUser method.
    @PostMapping
    // Binds the method parameter to the body of the HTTP request.
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}