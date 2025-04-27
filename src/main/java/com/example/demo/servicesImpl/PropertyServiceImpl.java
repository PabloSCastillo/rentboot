package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Property;
import com.example.demo.repositories.PropertyRepository;
import com.example.demo.services.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository;

	@Override
	public Property save(Property property) {
		return (Property)propertyRepository.save(property);
	}

	@Override
	public List<Property> findAll() {
		return (List<Property>) propertyRepository.findAll();
	}

	@Override
	public Property update(Property property) {
		return (Property)propertyRepository.save(property);
	}

	@Override
	public void delete(Long id) {
		propertyRepository.deleteById(id);
	}

	@Override
	public Optional<Property> getById(Long id) {
		return propertyRepository.findById(id);
	}
	
}
