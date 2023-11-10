package com.webservicejpa.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservicejpa.webservicejpa.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
