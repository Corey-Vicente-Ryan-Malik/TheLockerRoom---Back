package com.capstone.lockerapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"team"})
@Table(name = "forum_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_body", length = 500)
    private String postBody;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"posts", "password", "stake", "firstName", "lastName", "favTeam"})
    private User user;


    // CONSTRUCTORS
    public Post(long id, String postBody, User user) {
        this.id = id;
        this.postBody = postBody;
        this.user = user;
    }

    public Post(String postBody, User user) {
        this.postBody = postBody;
        this.user = user;
    }

    public Post() {}

    // GETTERS & SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
