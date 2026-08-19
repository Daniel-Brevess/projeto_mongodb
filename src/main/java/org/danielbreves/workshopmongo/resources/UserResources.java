package org.danielbreves.workshopmongo.resources;

import org.danielbreves.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResources {

    @GetMapping(value="/FindAll")
    public ResponseEntity <List<User>> FindAllUsers(User user) {

        User user1 = new User("1", "Jhon", "jhon@gmail.com");
        User user2 = new User("2", "Max", "Max@gmail.com");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        return ResponseEntity.ok(users);
    }

}
