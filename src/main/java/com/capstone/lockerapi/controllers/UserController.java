package com.capstone.lockerapi.controllers;


import com.capstone.lockerapi.exceptions.UserNotFoundException;
import com.capstone.lockerapi.models.User;
import com.capstone.lockerapi.repositories.UserRepository;
import com.capstone.lockerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User userToEdit, @PathVariable long id) {
        return userService.findById(id)
                .map(user -> {
                    user.setFirstName(userToEdit.getFirstName());
                    user.setLastName(userToEdit.getLastName());
                    user.setEmail(userToEdit.getEmail());
                    user.setUsername(userToEdit.getUsername());
                    user.setPassword(userToEdit.getPassword());
                    return userService.saveUser(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "User deleted.";
    }

}
