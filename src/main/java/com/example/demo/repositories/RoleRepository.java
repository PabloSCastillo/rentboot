package com.example.demo.repositories;

import java.util.Optional;

import javax.management.relation.RoleList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Role;
import com.example.demo.entities.enums.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
    // List<Role> findByUser(User user);
    // List<Role> findByUserIn(Set<User> users);
}
