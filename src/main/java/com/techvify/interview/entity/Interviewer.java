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
    @Column(name = "title_id" , nullable = false)
    private int title_id;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;


}
