package org.danielbreves.workshopmongo.resources;

import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.dto.UserDTO;
import org.danielbreves.workshopmongo.repository.UserRepository;
import org.danielbreves.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping(value="/FindAll")
    public ResponseEntity <List<UserDTO>> FindAllUsers(UserDTO user) {

        List<User> users = userService.findAll();
        List <UserDTO> listDTOs = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toUnmodifiableList());


        return ResponseEntity.ok(listDTOs);
    }

}
