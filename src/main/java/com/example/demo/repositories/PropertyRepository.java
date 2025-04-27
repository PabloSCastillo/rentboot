package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Property;


public interface PropertyRepository extends CrudRepository<Property, Long>{

}
