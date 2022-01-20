package com.example.securingweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecuringWebApplication {
    public static void main(String[] args){
        SpringApplication.run(SecuringWebApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode("3180057");
            User user1 = new User("3180057", encodedPassword, "This is a college student at AUEB");
            userRepository.save(user1);
        };
    }
}
