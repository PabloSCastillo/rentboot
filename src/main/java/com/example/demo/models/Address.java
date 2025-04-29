package com.example.demo.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	String street;
	String city;
	String state;
	String zip;
	String country;

}
