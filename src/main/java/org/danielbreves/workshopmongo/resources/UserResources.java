package org.danielbreves.workshopmongo.resources;

import org.danielbreves.workshopmongo.domain.Post;
import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.dto.AuthorDTO;
import org.danielbreves.workshopmongo.dto.UserDTO;
import org.danielbreves.workshopmongo.repository.UserRepository;
import org.danielbreves.workshopmongo.resources.exception.StandartErrorException;
import org.danielbreves.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value="/{id}")
    public ResponseEntity <UserDTO> findById(@PathVariable("id") String id) {

        User obj = userService.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping(value="/insert")
    public ResponseEntity <Void> insert(@RequestBody UserDTO dto) {

        User user = userService.fromDTO(dto);
        user = userService.insert(user);

       URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity <Void> delete(@PathVariable("id") String id) {

        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity <Void> update(@RequestBody UserDTO dto, @PathVariable("id") String id) {

        User user = userService.fromDTO(dto);
        user.setId(id);
        user = userService.update(user);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/{id}/posts")
    public ResponseEntity <List<Post>> findPostsById(@PathVariable("id") String id) {

        User obj = userService.findById(id);


        return ResponseEntity.ok().body(obj.getPosts());
    }

}
