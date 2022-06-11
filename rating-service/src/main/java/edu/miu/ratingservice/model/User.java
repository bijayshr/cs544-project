package edu.miu.ratingservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "subscribed")
    public Boolean subscribed;

    public User() {
    }

    public User(String name, String email, Boolean subscribed) {
        this.name = name;
        this.email = email;
        this.subscribed = subscribed;
    }

}