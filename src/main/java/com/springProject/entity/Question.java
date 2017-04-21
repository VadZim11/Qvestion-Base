package com.springProject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    private int id;

    private String question;

    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question() {

    }
}
