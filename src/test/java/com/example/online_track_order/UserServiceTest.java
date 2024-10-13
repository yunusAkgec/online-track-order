package com.example.online_track_order;

import com.example.online_track_order.Entity.User;
import com.example.online_track_order.Repository.UserRepository;
import com.example.online_track_order.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser(){
        String username = "testuser";
        String email = "testuser@example.com";
        String password = "password123";

        userService.registerUser(username,email,password);

        verify(userRepository,times(1)).save(any(User.class));
    }

}
