package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.exceptions.UserNotFoundException;
import com.capstone.lockerapi.models.User;
import com.capstone.lockerapi.models.UserRole;
import com.capstone.lockerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Mapping to CREATE new user entity.
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Sends 201 status, new resource has been created.
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/register").toUriString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.USER);
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    // Mapping to READ/VIEW all users.
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    @ResponseBody
    public User loggedInUser(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return user;
    }

    // Mapping to READ/VIEW single user.
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return ResponseEntity.ok().body(userService.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }


    // Mapping to UPDATE/EDIT user information.
    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/users/{id}/edit-profile")
    public ResponseEntity<User> updateUser(@RequestBody User userToEdit, @PathVariable long id) {
        return ResponseEntity.ok().body(userService.findById(id)
                .map(user -> {
                    user.setFirstName(userToEdit.getFirstName());
                    user.setLastName(userToEdit.getLastName());
                    user.setEmail(userToEdit.getEmail());
                    user.setUsername(userToEdit.getUsername());
                    user.setPassword(userToEdit.getPassword());
                    user.setRole(userToEdit.getRole());
                    return userService.saveUser(user);
                }).orElseThrow(() -> new UserNotFoundException(id)));
    }


    // Mapping to DELETE user entity.
    @DeleteMapping("/users/{id}/delete")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
