package com.springProject.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String login;

    @Column
    @NotNull
    private String password;

    @Column
    private String name;

    @Column
    @NotNull
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToOne
    @JoinColumn(name = "userStatisticId")
    private UserStatistic userStatistic;

    @OneToMany(mappedBy = "user")
    private Set<UserAchievement> userAchievementSet = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<QuestionStatistic> questionStatisticSet = new HashSet<>();

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserStatistic getUserStatistic() {
        return userStatistic;
   }

    public void setUserStatistic(UserStatistic userStatistic) {
        this.userStatistic = userStatistic;
    }

    public Set<UserAchievement> getUserAchievementSet() {
        return userAchievementSet;
    }

    public void setUserAchievementSet(Set<UserAchievement> userAchievementSet) {
        this.userAchievementSet = userAchievementSet;
    }

    public Set<QuestionStatistic> getQuestionStatisticSet() {
        return questionStatisticSet;
    }

    public void setQuestionStatisticSet(Set<QuestionStatistic> questionStatisticSet) {
        this.questionStatisticSet = questionStatisticSet;
    }
}
