package com.example.demo.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName().toString());

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Collections.singleton(authority)
        );
    }

    public boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
