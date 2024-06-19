package com.juint5.user;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {
    private UserRepository userRepository;
    private ExecutorService executorService;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.executorService = Executors.newSingleThreadExecutor();

    }

    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Saves the user asynchronously using CompletableFuture.
     * CompletableFuture is used to perform asynchronous computations.
     * It provides a way to execute tasks in a non-blocking manner.
     *
     * @param user the user to save
     * @return a CompletableFuture representing the pending completion of the task
     */
    public CompletableFuture<Void> saveUserAsync(User user) {
        return CompletableFuture.runAsync(() -> {
            try {
                // Simulate delay in saving user
                Thread.sleep(500);
                userRepository.save(user);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executorService);
    }
}