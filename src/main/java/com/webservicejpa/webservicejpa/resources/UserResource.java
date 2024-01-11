package com.webservicejpa.webservicejpa.resources;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservicejpa.webservicejpa.entities.User;
import com.webservicejpa.webservicejpa.services.UserService;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable UUID id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody User obj){
		Optional<User> user = service.findByName(obj.getName());
		
		if (!user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createErrorResponse("Usuário já existe"));
		}

		var passwordHashead = BCrypt.withDefaults().hashToString(12, obj.getPassword().trim().toCharArray());
		obj.setPassword(passwordHashead);
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(createSuccessResponse(obj));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody User obj){
		Optional<User> user = service.findByName(obj.getName());
		if (!user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createErrorResponse("Usuário já existe"));
		}
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(createSuccessResponse(obj));
	}
	
	private Map<String, Object> createSuccessResponse(User user) {
	    Map<String, Object> response = new HashMap<>();
	    response.put("type", "success");
	    response.put("data", user);
	    return response;
	}

	private Map<String, Object> createErrorResponse(String message) {
	    Map<String, Object> response = new HashMap<>();
	    response.put("type", "error");
	    response.put("message", message);
	    return response;
	}
}
