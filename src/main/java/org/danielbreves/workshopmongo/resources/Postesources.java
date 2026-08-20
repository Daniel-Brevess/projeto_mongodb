package org.danielbreves.workshopmongo.resources;

import org.danielbreves.workshopmongo.domain.Post;
import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.dto.UserDTO;
import org.danielbreves.workshopmongo.service.PostService;
import org.danielbreves.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.danielbreves.workshopmongo.resources.util.URL;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class Postesources {

    @Autowired
    private PostService postService;


    @GetMapping(value="/{id}")
    public ResponseEntity <Post> findById(@PathVariable("id") String id) {

        Post obj = postService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/titlesearch")
    public ResponseEntity <List<Post>> findBytitle(@RequestParam (value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {

        text = URL.decodeParam(text);

        List<Post> list = postService.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/authorsearch")
    public ResponseEntity <List<Post>> findByAuthor(@RequestParam (value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {

        text = URL.decodeParam(text);

        List<Post> list = postService.findByAuthor(text);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/fullsearch")
    public ResponseEntity <List<Post>> fullSearch(@RequestParam (value = "text", defaultValue = "") String text,
                                                    @RequestParam (value = "minDate", defaultValue = "") String minDate,
                                                  @RequestParam (value = "maxDate", defaultValue = "") String maxDate) throws UnsupportedEncodingException {

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = postService.fullSearch(text, min, max);

        return ResponseEntity.ok().body(list);
    }

}
