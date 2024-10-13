package com.example.online_track_order.Controller;

import com.example.online_track_order.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<String> registerUser(@RequestParam String username,
                                                @RequestParam String email,
                                                @RequestParam String password){
        userService.registerUser(username,email,password);
        return ResponseEntity.ok("User registered successfully");

    }
}
