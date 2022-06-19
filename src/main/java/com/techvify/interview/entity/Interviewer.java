package com.techvify.interview.entity;

import javax.persistence.*;

@Entity
@Table(name = "interviewer")
public class Interviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name" , nullable = false)
    private String full_name;
    @Column(name = "title_id" , nullable = false,insertable = false,updatable = false)
    private int title_id;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    public Interviewer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
