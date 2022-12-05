package com.springboot2application.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot2application.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
