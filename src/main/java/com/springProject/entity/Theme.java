package com.springProject.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int theme;

    @OneToMany(mappedBy = "theme")
    private Set<Question> users = new HashSet<>();

    public Theme() {
    }

    public int getId() {
        return id;
    }

     public void setId(int id) {
        this.id = id;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public Set<Question> getUsers() {
        return users;
    }

    public void setUsers(Set<Question> users) {
        this.users = users;
    }
}
