package cn.coolwind.shiro.web.entity;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = -8848468952704744351L;

    private int id;

    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role() {

    }

    public Role(int id, String role) {

        this.id = id;
        this.role = role;
    }
}
