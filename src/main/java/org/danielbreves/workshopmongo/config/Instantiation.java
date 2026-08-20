package org.danielbreves.workshopmongo.config;

import org.danielbreves.workshopmongo.domain.Post;
import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.dto.AuthorDTO;
import org.danielbreves.workshopmongo.dto.CommentDTO;
import org.danielbreves.workshopmongo.repository.PostRepository;
import org.danielbreves.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Bob o Construtor", "bobtheconstructor@gmail.com");
        User user2 = new User(null, "Bob Marley", "bobmarley@gmail.com");
        User user3 = new User(null, "Bob Esponja", "bobesponja@gmail.com");

        userRepository.saveAll(Arrays.asList(user1,user2,user3));

        Post post1 = new Post(null, sdf.parse("20/08/2026"), "Vou construir algo", "quero criar uma casa para meus cachorros", new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("20/08/2026"), "Vou fazer uma canção", "quero criar uma canção para meus cachorros",new AuthorDTO(user2));
        Post post3 = new Post(null, sdf.parse("20/08/2026"), "Vou caçar aguas vivas", "eu e patrick vamos caçar aguas vivas para se divertir", new AuthorDTO(user3));

        CommentDTO c1 = new CommentDTO("Boa mano!", sdf.parse("21/08/2014"), new AuthorDTO(user2));
        CommentDTO c2 = new CommentDTO("Posta quando estiver pronto!", sdf.parse("21/08/2014"), new AuthorDTO(user3));
        CommentDTO c3 = new CommentDTO("Boa mano!", sdf.parse("21/08/2014"), new AuthorDTO(user2));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        user1.getPosts().add(post1);
        userRepository.save(user1);

    }

    }

