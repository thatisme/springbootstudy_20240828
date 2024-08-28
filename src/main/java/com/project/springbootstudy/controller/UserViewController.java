package com.project.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class UserViewController {

    @GetMapping("")
    public String goLogin(){
        return "user/login";
    }

    @PostMapping("login-process")
    public String loginCheck(@RequestParam(name="userId") String userId
                             , @RequestParam(name="password") String password
                             , Model model)
    {
        HashMap<String , String> userInfo = new HashMap<>();
        if(userInfo.get(userId) != null)
        {
            if(userInfo.get(userId).equals(password))
                return "redirect:/home";
        }
        else {
            model.addAttribute("error","존재하지 않는 회원입니다. 회원가입이 필요합니다.");
        }
        return "user/login";
    }
}
