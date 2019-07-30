package com.xerovit.io.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xerovit.io.assignment.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

	User findByUsername(String username);

	boolean existsByTelephone(String string);

	boolean existsByEmail(String string);

}
