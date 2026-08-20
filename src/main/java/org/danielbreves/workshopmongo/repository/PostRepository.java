package org.danielbreves.workshopmongo.repository;

import org.danielbreves.workshopmongo.domain.Post;
import org.danielbreves.workshopmongo.domain.User;
import org.danielbreves.workshopmongo.dto.AuthorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("db.posts.find({ \"author.name\": \"name\" })")
    List<Post> findByAuthor(String name);

    List<Post> findByTitleContainingIgnoreCase(String text);
}