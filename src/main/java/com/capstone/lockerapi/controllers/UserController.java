package com.capstone.lockerapi.controllers;


import com.capstone.lockerapi.exceptions.UserNotFoundException;
import com.capstone.lockerapi.models.User;
import com.capstone.lockerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Sends 201 status, new resource has been created.
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return ResponseEntity.ok().body(userService.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User userToEdit, @PathVariable long id) {
        return ResponseEntity.ok().body(userService.findById(id)
                .map(user -> {
                    user.setFirstName(userToEdit.getFirstName());
                    user.setLastName(userToEdit.getLastName());
                    user.setEmail(userToEdit.getEmail());
                    user.setUsername(userToEdit.getUsername());
                    user.setPassword(userToEdit.getPassword());
                    return userService.saveUser(user);
                }).orElseThrow(() -> new UserNotFoundException(id)));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
