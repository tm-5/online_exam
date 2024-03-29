package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Exam;
import com.example.model.Question;
import com.example.repository.ExamRepository;
import com.example.repository.QuestionRepository;

@Controller
public class ExamController {
	@Autowired
	private ExamRepository repos;
	@Autowired
	private QuestionRepository qrepo;
	
	
	@GetMapping("/admin_home")
	public String viewExamLis(Model model) {
		List<Exam> exams=(List<Exam>) repos.findAll();
		model.addAttribute("exams", exams);
		return "admin_home";
	}
	@GetMapping("/manage_exam")
	public String viewExamList(Model model) {
		List<Exam> exams=(List<Exam>) repos.findAll();
		model.addAttribute("exams", exams);
		return "manage_exam";
	}
		
	@GetMapping("/saveExam")
	public String createExam(Model model) {
		model.addAttribute("exam", new Exam());
		return "createExam";
	}
	@PostMapping("/createExam")
    public String createExam(Exam exam, String[] questionText, String[] answer,
                             String[] optionA, String[] optionB, String[] optionC, String[] optionD) {
        // Save exam to database
        Exam savedExam = repos.save(exam);

        // Save questions to database
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < questionText.length; i++) {
            Question question = new Question();
            question.setQuestionText(questionText[i]);
            question.setAnswer(answer[i]);
            question.setOptionA(optionA[i]);
            question.setOptionB(optionB[i]);
            question.setOptionC(optionC[i]);
            question.setOptionD(optionD[i]);
            question.setExam(savedExam);
            questions.add(question);
        }
        qrepo.saveAll(questions);

        return "redirect:/admin_home";
    }
}


	
