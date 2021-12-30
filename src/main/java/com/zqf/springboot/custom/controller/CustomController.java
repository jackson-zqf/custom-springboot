package com.zqf.springboot.custom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @RequestMapping("/test")
    public  String test(){
        return "hello";
    }
}
