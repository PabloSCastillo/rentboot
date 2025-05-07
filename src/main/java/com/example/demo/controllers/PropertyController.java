package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Property;
import com.example.demo.services.PropertyService;

@RestController
@RequestMapping("/api/v1/properties")

public class PropertyController {

	private static final  Logger logger = LoggerFactory.getLogger(PropertyController.class);
	
	@Autowired
	PropertyService propertyService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Property property) {
		logger.info("Creating a property {}", property.toString());
		Property newProperty = propertyService.save(property);
		return ResponseEntity.status(201).body(newProperty);
	}

	@GetMapping
	public ResponseEntity<List<Property>> getAll() {
		List<Property> properties = propertyService.findAll();
		return ResponseEntity.ok(properties);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long idProperty) {
		Optional<Property> property = propertyService.getById(idProperty);
		return ResponseEntity.status(200).body(property);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long idProperty){
		Optional<Property> property = propertyService.getById(idProperty);
		propertyService.delete(idProperty);
		return ResponseEntity.status(200).body(property);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Property property){
		Property updatedProperty = propertyService.update(property);
		return ResponseEntity.status(200).body(updatedProperty);
	}
}
