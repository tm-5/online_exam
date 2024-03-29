package com.example.model;

import jakarta.persistence.*;

@Entity
public class Result {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
    
    @Column
    private int score;
    
    // Constructors, getters, and setters
    // Constructors, getters, and setters
}
