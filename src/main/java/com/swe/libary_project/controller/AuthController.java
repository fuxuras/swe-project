package com.swe.libary_project.controller;

import com.swe.libary_project.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/regiseter")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String mail){
        if (memberService.createMember(username,mail,password)){
            return "redirect:/login";
        }else {
            return "redirect:/register?error";
        }
    }
}