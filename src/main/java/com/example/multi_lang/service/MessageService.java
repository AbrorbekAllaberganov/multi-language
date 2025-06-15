package com.example.multi_lang.service;

import com.example.multi_lang.entity.User;
import io.swagger.v3.oas.models.responses.ApiResponse;
import java.util.Locale;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageSource messageSource;

    public ResponseEntity<String> getMessage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Locale locale = user.getLanguage().toLocale();
        String message = messageSource.getMessage("user.welcome", null, locale);
        return ResponseEntity.ok(message);
    }
}
