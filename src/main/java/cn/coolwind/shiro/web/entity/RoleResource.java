package cn.coolwind.shiro.web.entity;

public class RoleResource {

    private String role;

    private String resource;

    public RoleResource() {
    }

    public RoleResource(String role, String resource) {

        this.role = role;
        this.resource = resource;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
