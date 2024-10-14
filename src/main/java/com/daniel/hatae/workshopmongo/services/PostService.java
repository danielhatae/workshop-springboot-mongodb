package com.daniel.hatae.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.hatae.workshopmongo.domain.Post;
import com.daniel.hatae.workshopmongo.repository.PostRepository;
import com.daniel.hatae.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
	}
	
	public List<Post> findByTitle(String text){
		//return repo.findByTitle(text); para ser case sensetive
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> searchTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullsearch(String text, Date minDate, Date maxDate){
		//Para pegar a data máxima até as 23:59:50
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 *100);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
