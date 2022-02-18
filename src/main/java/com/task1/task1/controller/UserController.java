package com.task1.task1.controller;

import com.task1.task1.Dto.UserDto;
import com.task1.task1.entity.Users;
import com.task1.task1.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/users")
    public List<Users> getUsers() {
        return userService.findAll();
    }

    @DeleteMapping("/delete/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/put/user/{id}")
    public void updateExistingUser(@PathVariable Long id, @RequestBody UserDto updatedUser) {
        userService.updateExistingUser(id, updatedUser);
    }

    @PostMapping("/post/user")
    public Users createNewUser(@RequestBody Users newUser) {
        return userService.saveNewUser(newUser);
    }
}
