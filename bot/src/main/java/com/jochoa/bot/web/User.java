package com.jochoa.bot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/")
public class User {
    @GetMapping("/")
    public ResponseEntity test(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
