package org.danielbreves.workshopmongo.resources;

import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.repository.UserRepository;
import org.danielbreves.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping(value="/FindAll")
    public ResponseEntity <List<User>> FindAllUsers(User user) {

        List<User> users = userService.findAll();
        System.out.println("Quantidade encontrada: " + users.size());


        return ResponseEntity.ok(users);
    }

}
