package com.daniel.hatae.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.daniel.hatae.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//List<Post> findByTitleContaining(String text); 
	List<Post> findByTitleContainingIgnoreCase(String text); 

}
