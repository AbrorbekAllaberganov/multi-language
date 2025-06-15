package com.example.multi_lang.controller;

import com.example.multi_lang.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    @GetMapping(produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> getMessage(){
        return messageService.getMessage();
    }
}
