package com.negotium.registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long roleID;
    private String role;

    public Role(){

    }

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
