package com.project.springbootstudy.controller;

import com.project.springbootstudy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinViewController {
    @GetMapping("user/join")
    public String join() {
        return "user/join";
    }

    @PostMapping("join-process")
    public String joinProcess(@ModelAttribute User user , Model model) {

        boolean isJoinSuccess = true;
        if(isJoinSuccess) {
            return "redirect:/user/login";
        } else {
            model.addAttribute("error" , "회원가입에 실패하셨습니다.");
            return "/user/join";
        }
    }
}
