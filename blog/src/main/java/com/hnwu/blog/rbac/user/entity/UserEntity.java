package com.hnwu.blog.rbac.user.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

/**
 * Created by 吴会楠 on 2018/1/2.
 */
public class UserEntity  {
    private Long id ;
    private String username;
    private String password;
    private String description;
    private String roles;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
