package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Property;

public interface PropertyService {
	
	Property save(Property property);
	Property update(Property property);
	List<Property> findAll();
	void delete(Long id);
	Optional getById(Long id);
	
}
