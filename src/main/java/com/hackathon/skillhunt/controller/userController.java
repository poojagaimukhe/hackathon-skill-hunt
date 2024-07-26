package com.hackathon.skillhunt.controller;

import com.hackathon.skillhunt.dto.AuthRequest;
import com.hackathon.skillhunt.entity.SkillsMaster;
import com.hackathon.skillhunt.entity.UserInfo;
import com.hackathon.skillhunt.service.JwtService;
import com.hackathon.skillhunt.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class userController {

    @Autowired
    private userService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcomeAdmin")
    @PreAuthorize("hasAuthority('admin')")
    public String welcomeAdmin() {
        return "Welcome to Admin";
    }

    @GetMapping("/welcomeUser")
    public String welcomeUser() {
        return "Welcome to User";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {

        return service.addUser(userInfo);
    }

//    @GetMapping("/all")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public List<Product> getAllTheProducts() {
//        return service.getProducts();
//    }

//    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public Product getProductById(@PathVariable int id) {
//        return service.getProduct(id);
//    }


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }




    }
}
