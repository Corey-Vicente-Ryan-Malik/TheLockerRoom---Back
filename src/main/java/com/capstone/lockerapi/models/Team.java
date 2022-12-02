package com.capstone.lockerapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
