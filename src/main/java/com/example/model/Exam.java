package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="exam")
public class Exam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "exam_name", nullable=false)
    private String examName;
    
    @Column(name = "total_question", nullable=false)
    private int totalQuestion;
    
    @Column(name = "session_name", nullable = false) 
    private String sessionName;
    
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Question> questions;

    public Exam(Long id, String examName, int totalQuestion, String sessionName, boolean enabled,
			List<Question> questions) {
		super();
		this.id = id;
		this.examName = examName;
		this.totalQuestion = totalQuestion;
		this.sessionName = sessionName;
		this.enabled = enabled;
		this.questions = questions;
	}


	public String getSessionName() {
		return sessionName;
	}


	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Column(name = "enabled", nullable = false)
    private boolean enabled;
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public Exam() {
		super();
	}


	public int getTotalQuestion() {
		return totalQuestion;
	}


	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}


	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

    
}
