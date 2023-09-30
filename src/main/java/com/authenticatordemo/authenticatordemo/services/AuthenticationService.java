package com.authenticatordemo.authenticatordemo.services;

import com.authenticatordemo.authenticatordemo.models.Role;
import com.authenticatordemo.authenticatordemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.authenticatordemo.authenticatordemo.models.rest.Response;
import com.authenticatordemo.authenticatordemo.repository.RoleRepository;
import com.authenticatordemo.authenticatordemo.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@Transactional
public class AuthenticationService {
    // Won't allow multiple database calls and preserves ACID properties
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;


    public User registerUser(String name, String username, String password){

        String encodedPassword = encoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();


        return userRepository.save(new User(name, username, encodedPassword, userRole));
    }

    public Response loginUser(String username, String password){

        try{
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new Response(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new Response(null, "");
        }
    }
}
