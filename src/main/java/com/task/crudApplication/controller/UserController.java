package com.task.crudApplication.controller;

import com.task.crudApplication.Dto.UserDto;
import com.task.crudApplication.entity.User;
import com.task.crudApplication.exception.UserNotFoundException;
import com.task.crudApplication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable @Digits(integer = 4, fraction = 0) int id)
            throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok("User with the ID: " + id + " was deleted");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateExistingUser(
            @PathVariable @Digits(integer = 4, fraction = 0) int id,
            @RequestBody @Valid UserDto updatedUser) throws UserNotFoundException {
        userService.updateExistingUser(id, updatedUser);
        return ResponseEntity.ok("User with the ID: " + id + " was updated");
    }

    @PostMapping("/post")
    public ResponseEntity<String> createNewUser(@RequestBody @Valid User newUser) {
        userService.saveNewUser(newUser);
        return ResponseEntity.ok("User was created");
    }
}
