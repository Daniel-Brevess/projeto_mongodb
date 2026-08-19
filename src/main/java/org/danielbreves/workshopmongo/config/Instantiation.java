package org.danielbreves.workshopmongo.config;

import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user1 = new User(null, "Bob o Construtor", "bobtheconstructor@gmail.com");
        User user2 = new User(null, "Bob Marley", "bobmarley@gmail.com");
        User user3 = new User(null, "Bob Esponja", "bobesponja@gmail.com");

        userRepository.saveAll(Arrays.asList(user1,user2,user3));
    }

    }

