package com.kys95.checkstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping("/taskForm")
    public String taskForm(){
        return "task/taskForm";
    }
}