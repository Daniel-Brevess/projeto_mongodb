package org.danielbreves.workshopmongo.service;

import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.dto.UserDTO;
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

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO dto) {

        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public User update(User user) {
        User newUser = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException(
                "Usuário não encontrado: " + user.getId()));
        
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
