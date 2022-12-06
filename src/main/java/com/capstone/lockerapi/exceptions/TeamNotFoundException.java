package com.capstone.lockerapi.exceptions;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(long id) {
        super("ERROR: Could not find team with the ID: " + id);
    }
}
