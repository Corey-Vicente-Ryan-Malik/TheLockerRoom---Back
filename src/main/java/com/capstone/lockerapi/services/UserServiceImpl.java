package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.User;
import com.capstone.lockerapi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to database.", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        log.info("Deleting user with the id {}.", id);
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(long id) {
        log.info("Fetching user with the id {}.", id);
        return userRepository.findById(id);
    }

//    @Override
//    public User findByUsername(String username) {
//        List<User> userToReturn = new ArrayList<>();
//        for(User user : getAllUsers()) {
//            if (user.getUsername().equals(username)) {
//                userToReturn.add(user);
//            }
//        }
//        User userFound = new User(userToReturn.get(0).getFirstName(), userToReturn.get(0).getLastName(), userToReturn.get(0).getEmail(), userToReturn.get(0).getUsername(), userToReturn.get(0).getPassword());
//        return userFound;
//    }

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users.");
        return userRepository.findAll();
    }
}
