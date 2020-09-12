package com.edukart.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationUIController {
	
	@GetMapping("/login")
    public String showLogin(Model model) {
        return "Login";
    }
	
	@GetMapping("/signup")
    public String showSignUp(Model model) {
        return "SignUp";
    }
	
	@PostMapping("/login")
    public String login(@RequestParam("title") String title, Model model) {
        return "redirect:/";
    }
	
	@PostMapping("/signup")
    public String signup(@RequestParam("title") String title, Model model) {
        return "redirect:/photos/";
    }
}
