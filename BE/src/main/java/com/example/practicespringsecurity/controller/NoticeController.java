package com.example.practicespringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @GetMapping("/notice")  // 이걸 /notice라는 Rest 서비스라고 표현했음.
    public String getNoticeDetails(){
        return "노티스..";
    }
}
