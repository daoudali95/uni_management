package com.example.unimanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    private Set<Authority> authorized_User = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "user_authorities",
            joinColumns ={@JoinColumn(name="user_id" , referencedColumnName ="id")},
            inverseJoinColumns = {@JoinColumn(name="authority_name", referencedColumnName = "name")})
    private Set<Authority> authorized_User = new HashSet<>();


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Authority> getAuthorized_User() {
        return authorized_User;
    }

    public void setAuthorized_User(Set<Authority> authorized_User) {
        this.authorized_User = authorized_User;
    }

}
