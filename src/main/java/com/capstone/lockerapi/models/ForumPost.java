package com.capstone.lockerapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "forum_posts")
public class ForumPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_body")
    private String postBody;
}
