package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dtos.NewUserDto;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.Roles;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.repositories.RoleRepository;

@Service
public class AuthService {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    public AuthService(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

    public void registerUser(NewUserDto newUserDto) {
        if (userService.existsByUserName(newUserDto.getUserName())) {
            throw new IllegalArgumentException("Username does already exist");
        }

        Role roleUser = roleRepository.findByName(Roles.USER)
                .orElseThrow(() -> new RuntimeException("Role not found: " + Roles.USER));
        User user = new User(newUserDto.getUserName(), passwordEncoder.encode(newUserDto.getPassword()), roleUser);
        userService.save(user);
    }
}
