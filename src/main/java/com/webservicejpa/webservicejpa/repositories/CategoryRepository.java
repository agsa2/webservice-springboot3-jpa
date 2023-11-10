package com.webservicejpa.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservicejpa.webservicejpa.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
