package com.example.demo.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	String street;
	String city;
	String state;
	String zip;
	String country;

}
