package com.example.Recipe.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Date dateOfBirth;
    @Column(nullable = false)
    private String nationality;
    @Column(nullable = false)
    private String bio;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToMany(mappedBy = "userOwnRecipe")
    List<Recipe> ownRecipes;

    @OneToMany(mappedBy = "userFavRecipe")
    List<Recipe> favoriteRecipes;

    @OneToMany(mappedBy = "userComments")///////////////////////////
    List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "user_user",
            joinColumns = {@JoinColumn(name = "from_id")},
            inverseJoinColumns = {@JoinColumn(name = "to_id")}
    )
    public List<UserApp> following;

    @ManyToMany(mappedBy = "following", fetch = FetchType.EAGER)
    public List<UserApp> followers;

    public UserApp() {
    }

    public UserApp(String username, String password, String firstName, String lastName, Date dateOfBirth, String nationality, String bio, Role role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.bio = bio;
        this.role = role;

    }

    public Long getId() {
        return id;
    }
}