package com.prog.controller;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping
    public String home()
    {
        return "index";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UserDtls u, HttpSession session)
    {
        System.out.println(u);
        repo.save(u);
        session.setAttribute("message", "User register successfully");

        return "redirect:/";
    }
}
