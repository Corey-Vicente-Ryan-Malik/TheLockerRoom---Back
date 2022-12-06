package com.capstone.lockerapi.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super("ERROR: Could not find user with the ID: " + id);
    }
}
