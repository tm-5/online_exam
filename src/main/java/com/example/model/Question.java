package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="question")
public class Question {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "question_text", nullable=false)
	private String questionText;
	@Column(name="answer", nullable=false)
	private String answer;
	
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	@ManyToOne
	@JoinColumn(name = "exam_id", nullable = false)
	private Exam exam;
	
    public Question(Long id, String questionText, String answer, String optionA, String optionB, String optionC,
			String optionD, Exam exam) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.answer = answer;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.exam = exam;
	}

	public Question() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	  
    public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
    
    // Constructors, getters, and setters
    // Constructors, getters, and setters
}
