package com.hnwu.blog.rbac.menu;

/**
 * Created by 吴会楠 on 2018/1/2.
 */
public class Menu {
    private Long id;
    private String menuname;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
