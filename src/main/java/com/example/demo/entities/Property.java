package com.example.demo.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")

public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(hidden = true)
	Long id;

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
	@Schema(hidden = true)
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Schema(hidden = true)
	private LocalDateTime updatedAt;

}
