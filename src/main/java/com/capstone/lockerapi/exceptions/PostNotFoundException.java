package com.capstone.lockerapi.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(long id) {
        super("ERROR: No post with the ID: " + id + " found.");
    }
}
