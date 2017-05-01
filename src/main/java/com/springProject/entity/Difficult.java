package com.springProject.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Difficult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String difficult;

    @OneToMany(mappedBy = "difficult")
    private Set<Question> users = new HashSet<>();

    public Difficult() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public Set<Question> getUsers() {
       return users;
    }

    public void setUsers(Set<Question> users) {
        this.users = users;
    }
}
