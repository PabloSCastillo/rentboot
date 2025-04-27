package com.example.demo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")
@ToString(exclude = "id")
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "type")
	String type;

	@Embedded
	Address address;
	float price;
	String bedrooms;
	String bathrooms;
	String latitude;
	String longitude;
	boolean available;
	
	@CreatedDate
	@Column(updatable = false)
	LocalDateTime createdAt;
	
	@LastModifiedDate
	LocalDateTime updatedAt;

}
