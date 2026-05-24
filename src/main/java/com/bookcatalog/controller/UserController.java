package com.bookcatalog.controller;

import com.bookcatalog.entity.User;
import com.bookcatalog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {

        logger.info("Getting all users");

        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        logger.info("Getting user by id: {}", id);

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {

        logger.info("Creating user: {}", user.getUsername());

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        logger.info("Deleting user with id: {}", id);

        userRepository.deleteById(id);
    }
}