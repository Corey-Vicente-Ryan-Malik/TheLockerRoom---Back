package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.User;
import com.capstone.lockerapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
