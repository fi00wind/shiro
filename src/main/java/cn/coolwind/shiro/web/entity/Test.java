package cn.coolwind.shiro.web.entity;

import java.io.Serializable;

public class Test implements Serializable {

    private static final long serialVersionUID = -2537690016766908687L;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private int id;

    private String name;

    private String value;

    public Test(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Test() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
