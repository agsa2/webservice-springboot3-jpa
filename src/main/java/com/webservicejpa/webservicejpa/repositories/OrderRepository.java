package com.webservicejpa.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservicejpa.webservicejpa.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
