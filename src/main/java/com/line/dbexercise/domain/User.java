package com.line.dbexercise.domain;

public class User {
    private String id;
    private String name;
    private String password;

    public User() {
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId(String id) {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}