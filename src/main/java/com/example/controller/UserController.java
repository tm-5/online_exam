package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;
import com.example.repository.UserRepository;


@Controller
public class UserController {
	@Autowired 
	private UserRepository repo;
	@GetMapping("/manage_user")
	public String viewUserList(Model model) {
		List<User> list=(List<User>) repo.findAll();
		model.addAttribute("list",list);
		return "manage_user";
	}
	
	@GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value ="id") String id) {
		Optional<User> d=repo.findById(id);
		User g=d.get();
        repo.delete(g);
        return "redirect:/manage_user";
    }
	
	//public String showUserForm
	
}
