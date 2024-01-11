package com.webservicejpa.webservicejpa.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webservicejpa.webservicejpa.entities.User;
import com.webservicejpa.webservicejpa.repositories.UserRepository;
import com.webservicejpa.webservicejpa.services.exceptions.DatabaseException;
import com.webservicejpa.webservicejpa.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return this.repository.findAll();
	}
	
	public User findById(UUID id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Optional<User> findByName(String name) {
		Optional<User> obj = repository.findByName(name);
		return obj;
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(UUID id) {
		try {
			Optional<User> userOptional = repository.findById(id);
			
			if (userOptional.isPresent()) {
				repository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
	
	public User update(UUID id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(obj);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
			
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

	}
