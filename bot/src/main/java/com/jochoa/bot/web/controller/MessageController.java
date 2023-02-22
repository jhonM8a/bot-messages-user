package com.jochoa.bot.web.controller;

import com.jochoa.bot.domain.Message;
import com.jochoa.bot.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/set")
    public ResponseEntity setMessage(@RequestBody Message message){
        messageService.setMessage(message.getText());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
