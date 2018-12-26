package cn.coolwind.shiro.web.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -4020758309433097920L;

    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(int id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }
}