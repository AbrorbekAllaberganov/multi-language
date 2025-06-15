package com.example.multi_lang.service;

import com.example.multi_lang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {
    @Autowired
    private final MessageSource messageSource;
    private List<User> userList = new ArrayList<>();

    public UserService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private List<User> getUsers(){
//         messageSource.getMessage("users", null, )
        messageSource.getMessage("user.not.found", null, Locale.ENGLISH);
        return userList;
    }
}
