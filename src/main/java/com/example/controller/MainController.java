package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.Exam;
import com.example.model.User;
import com.example.repository.ExamRepository;
import com.example.repository.UserRepository;

@Controller
public class MainController {
	@Autowired
	private UserRepository repo;
	@Autowired
	private ExamRepository repos; 
	
	@GetMapping("/")
	public String viewHomePage() {
	        return "index"; // Điều hướng đến trang index.html
    }
	
    @GetMapping("/login")
    public String login(Model model) {
    	User user=new User();
    	model.addAttribute("user", user);
        return "login"; // Điều hướng đến trang đăng nhập (login.html)
    }
    
    
    
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
    	Optional<User> userdata= repo.findById(user.getId());
    	User us=userdata.get();
    	if(us.getId().equals("admin")) {
    		if(user.getPassword().equals(us.getPassword())){
    			return "admin_home";
    		}
    	}
    	else if(user.getPassword().equals(us.getPassword())) {
    		List<Exam> exams=(List<Exam>) repos.findAll();
    		model.addAttribute("exams", exams);
    		return "home";
    		
    	}
    	
    	return "error";
    }
    
    
    @GetMapping("/register")
    public String register(Model model) {
    	model.addAttribute("user",new User());
    	return "register";
    }
    
    @PostMapping("/process_register")
    public String showRegistrationForm(User user) {
    	repo.save(user);
        return "index"; // Điều hướng đến trang đăng ký (register.html)
    }
    /*
    @PostMapping("/login")
    public String checkLogin(@RequestParam("id") String id, 
    		@RequestParam("password") String password) {
    	repo.findById(id);
    //	Boolean isPasswordMatch=
    	return "home";
    }*/
}