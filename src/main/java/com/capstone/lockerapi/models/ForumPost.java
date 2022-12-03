package com.capstone.lockerapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "forum_posts")
public class ForumPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_body", length = 500)
    private String postBody;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // CONSTRUCTORS
    // First one with id.
    // Second one without id.
    public ForumPost(long id, String postBody, User user, Team team) {
        this.id = id;
        this.postBody = postBody;
        this.user = user;
        this.team = team;
    }

    public ForumPost(String postBody, User user, Team team) {
        this.postBody = postBody;
        this.user = user;
        this.team = team;
    }

    public ForumPost() {}

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
