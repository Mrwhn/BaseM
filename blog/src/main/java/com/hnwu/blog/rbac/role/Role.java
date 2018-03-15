package com.hnwu.blog.rbac.role;

/**
 * Created by 吴会楠 on 2018/1/2.
 */
public class Role {
    private Long id;
    private String rolename;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
