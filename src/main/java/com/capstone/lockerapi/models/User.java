package com.capstone.lockerapi.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false)
    private int favoriteTeam;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;

    // One user can have many posts.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    // One user can have one favorite team.
    @OneToOne
    private Team favTeam;

    // #Subject to change
    // One user can have one stake open at a time.
    @OneToOne
    private Stake stake;


    // CONSTRUCTORS
    // First one with all fields.
    // Second one for registration without favorite team.
    // Third one for registration with favorite team.
    public User(long id, String firstName, String lastName, String username, String email, String password, List<Post> posts, int favoriteTeam, Stake stake) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.favoriteTeam = favoriteTeam;
        this.stake = stake;
    }

    public User(String firstName, String lastName, String username, String email, String password, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, String username, String email, String password, int favoriteTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.favoriteTeam = favoriteTeam;
    }

    public User(String firstName, String lastName, String username, String email, String password, UserRole role, int favoriteTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.favoriteTeam = favoriteTeam;
    }

    public User(long id, String firstName, String lastName, String username, String password, int favoriteTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.favoriteTeam = favoriteTeam;
    }

    public User() {}

    public User(String firstName, String lastName, String username, int favoriteTeam, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.favoriteTeam = favoriteTeam;
        this.email = email;
        this.password = password;
    }

    public User(long id, String firstName, String lastName, String username, int favoriteTeam, String email, String password, UserRole role, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.favoriteTeam = favoriteTeam;
        this.email = email;
        this.password = password;
        this.role = role;
        this.posts = posts;
    }

    public int getFavoriteTeam() {
        return favoriteTeam;
    }

    public void setFavoriteTeam(int favoriteTeam) {
        this.favoriteTeam = favoriteTeam;
    }
// GETTERS & SETTERS

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Team getFavTeam() {
        return favTeam;
    }

    public void setFavTeam(Team favTeam) {
        this.favTeam = favTeam;
    }

    public Stake getStake() {
        return stake;
    }

    public void setStake(Stake stake) {
        this.stake = stake;
    }
}
