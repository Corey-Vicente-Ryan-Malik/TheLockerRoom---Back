package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);
    public void deleteUserById(long id);
    public Optional<User> findById(long id);
    public List<User> getAllUsers();

}
