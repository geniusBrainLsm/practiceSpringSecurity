package com.example.practicespringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/myCards")
    public String getBalanceDetails(){
        return "너의 카드디테일";
    }
}
