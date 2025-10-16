package com.example.demo.dtos;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

import com.example.demo.entities.Role;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {

    @Column(name = "username")
    private String userame;
    private String password;
    private Role rol = new Role() ;
    
}
