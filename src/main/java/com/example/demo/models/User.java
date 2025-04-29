package com.example.demo.models;

import java.util.List;

public class User {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String phoneNumber;
    String licenseNumber;
    String agency;
    List<Property> assignedProperties;
    Role rol;

}
