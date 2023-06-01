package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.FeedbackService;
import com.example.demo.model.Feedback;
import com.example.demo.model.User;

@Controller
public class FeedbackController {
	@Autowired
	private FeedbackService fbService;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/feedback")
	public String feedback(Model model, Principal principal) {
		String username=principal.getName();
		User user= userRepository.findByEmail(username);
		Feedback fb=new Feedback();
		System.out.println("Lekhana "+user);
		model.addAttribute("fb",fb);
		model.addAttribute("user", user);
		return "feedback";
		
	}
	
	@PostMapping("/feedbackUser")
	public String feedbackUser(@ModelAttribute("fb")Feedback fb) {
		
		System.out.println(fb);
	  fbService.feedbackUser(fb);
	  return"redirect:/homepage";
	}

}
