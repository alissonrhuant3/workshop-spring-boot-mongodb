package com.alisson.workshopmongo.repository;

import com.alisson.workshopmongo.domain.Post;
import com.alisson.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
