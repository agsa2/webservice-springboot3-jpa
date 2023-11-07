package com.webservicejpa.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservicejpa.webservicejpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
