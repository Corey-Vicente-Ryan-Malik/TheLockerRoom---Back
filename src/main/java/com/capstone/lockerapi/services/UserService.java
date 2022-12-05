package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.User;

public interface UserService {

    public User saveUser(User user);
    public void deleteUserById(long id);

    public User findUserById(long id);

}
