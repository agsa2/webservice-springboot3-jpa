package com.webservicejpa.webservicejpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.webservicejpa.webservicejpa.entities.User;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
	
	Optional<User> findByName(String name);
}
