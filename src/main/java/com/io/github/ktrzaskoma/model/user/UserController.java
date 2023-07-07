package com.io.github.ktrzaskoma.model.user;

import com.io.github.ktrzaskoma.dtos.user.UserReadModel;
import com.io.github.ktrzaskoma.dtos.user.UserWriteModel;
import com.io.github.ktrzaskoma.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserReadModel> readAllUsers() {
        LOGGER.warn("Exposing all users");
        return userService.showAllUsers();
    }


    @PostMapping
    ResponseEntity<?> createLocation (@RequestBody @Valid UserWriteModel userWriteModel) {
        UserReadModel user =  userService.saveUser(userWriteModel);
       return ResponseEntity.created(URI.create("/" + user.getId())).build();
    }


}
