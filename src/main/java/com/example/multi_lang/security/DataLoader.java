package com.example.multi_lang.security;


import com.example.multi_lang.entity.Language;
import com.example.multi_lang.entity.Role;
import com.example.multi_lang.entity.User;
import com.example.multi_lang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (init.equals("create")) {

            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setRole(Role.USER);
                user.setPassword(passwordEncoder.encode("123"));
                user.setFullName("user - 1");
                user.setPhoneNumber("+"+i);
                user.setLanguage(Language.values()[i % 3]);
                userRepository.save(user);
            }

        }
    }
}
