package org.danielbreves.workshopmongo.service;

import org.danielbreves.workshopmongo.domain.Post;
import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.dto.UserDTO;
import org.danielbreves.workshopmongo.repository.PostRepository;
import org.danielbreves.workshopmongo.repository.UserRepository;
import org.danielbreves.workshopmongo.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Post não encontrado: " + id));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }


}
