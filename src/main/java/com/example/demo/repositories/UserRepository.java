package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
    boolean existsByUserName(String username);
    /*Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);
    List<User> findByRoleIn(Set<Role> roles);*/
    
}
