package com.negotium.registration.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userID;
    @Column(unique=true)
    private String login;
    @Column(unique=true)
    private String email;
    //@NotNull
    private String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "roleID"))
    private Set<Role> roles;

    public User(){

    }

    public User(Long userID, String login, String email, String password, Set<Role> roles) {
        this.userID = userID;
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
