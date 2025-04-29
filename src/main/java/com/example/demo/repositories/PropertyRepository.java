package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Property;


public interface PropertyRepository extends JpaRepository<Property, Long>{

}
