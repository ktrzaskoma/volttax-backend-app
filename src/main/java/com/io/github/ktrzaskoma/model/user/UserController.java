package com.io.github.ktrzaskoma.model.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    ResponseEntity<List<User>> readAllUsers() {
        LOGGER.warn("Exposing all users");
        return ResponseEntity.ok(userRepository.findAll());
    }

    // TODO: implementing read- and write- model to project

    @PostMapping
    ResponseEntity<User> createLocation (@RequestBody User toCreate) {
        User user = userRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + user.getId())).body(user);
    }

}
