package com.kys95.checkstudy.controller;

import com.kys95.checkstudy.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/join")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("loginForm")
    public String loginForm(){
        return "user/loginForm";
    }


    @GetMapping("userInfo")
    public String userInfo(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("userId",principalDetails.getUserId());
        model.addAttribute("username",principalDetails.getUsername());
        model.addAttribute("email",principalDetails.getEmail());
        model.addAttribute("nickname",principalDetails.getNickname());
        return "/user/userInfo";
    }
}
