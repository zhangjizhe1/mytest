package cn.tedu.domain;

import java.util.List;

public class User {
    private int id;
    private String name;
    private List<String> addrs;

    public User() {
    }

    public User(int id, String name, List<String> addrs) {
        this.id = id;
        this.name = name;
        this.addrs = addrs;
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

    public List<String> getAddrs() {
        return addrs;
    }

    public void setAddrs(List<String> addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addrs=" + addrs +
                '}';
    }
}
