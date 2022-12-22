package com.springboot2application.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot2application.workshopmongo.domain.Post;
import com.springboot2application.workshopmongo.repository.PostRepository;
import com.springboot2application.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
	
	public List<Post> customSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 + 60 + 60 + 1000);
		return postRepository.customSearch(text, minDate, maxDate);
	}
}
