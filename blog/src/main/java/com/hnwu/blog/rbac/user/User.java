package com.hnwu.blog.rbac.user;

/**
 * Created by 吴会楠 on 2018/1/2.
 */
public class User {
    private Long id ;
    private String username;
    private String description;

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


}
