package com.example.online_track_order.Service;

import com.example.online_track_order.Entity.User;
import com.example.online_track_order.Repository.UserRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username,String email,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        userRepository.save(user);
    }

    public User findByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(()-> new RuntimeException("User not found"));
    }
}
