package com.spring.data.jpa.tutorial.repository;

import com.spring.data.jpa.tutorial.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface ProductRepo extends JpaRepository <Product, Long> {
}

