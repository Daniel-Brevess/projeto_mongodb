package org.danielbreves.workshopmongo.repository;

import org.danielbreves.workshopmongo.domain.Post;
import org.danielbreves.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}