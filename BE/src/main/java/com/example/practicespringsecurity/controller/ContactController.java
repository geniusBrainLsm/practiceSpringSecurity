package com.example.practicespringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contact")
    public String getBalanceDetails(){
        return "컨택트 ㄱㄱㄱ";
    }
}
