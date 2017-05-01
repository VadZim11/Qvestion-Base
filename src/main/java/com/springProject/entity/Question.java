package com.springProject.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String question;

    private String corectAnswers;

    private String answer1;

    private String answer2;

    private String answer3;

    private String answer4;

    @ManyToOne
    @JoinColumn(name = "difficultId")
    private Difficult difficult;

    @ManyToOne
    @JoinColumn(name = "themetId")
    private Theme theme;

    @OneToMany(mappedBy = "question")
    private Set<QuestionStatistic> questionStatisticSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorectAnswers() {
        return corectAnswers;
    }

    public void setCorectAnswers(String correectAnswers) {
        this.corectAnswers = correectAnswers;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public Difficult getDifficult() {
        return difficult;
    }

    public void setDifficult(Difficult difficult) {
        this.difficult = difficult;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Set<QuestionStatistic> getQuestionStatisticSet() {
        return questionStatisticSet;
    }

    public void setQuestionStatisticSet(Set<QuestionStatistic> questionStatisticSet) {
        this.questionStatisticSet = questionStatisticSet;
    }
}
