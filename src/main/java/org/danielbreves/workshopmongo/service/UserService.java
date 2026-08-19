package org.danielbreves.workshopmongo.service;

import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.repository.UserRepository;
import org.danielbreves.workshopmongo.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();

    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado: " + id));
    }
}
