package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.security.config.auth.CredentialsDto;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.User;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody CredentialsDto credentialsDto) {
        User user = userService.loginUser(credentialsDto);
        if (user != null) {
            return ResponseEntity.ok(user); // Return user if login is successful
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Return 401 Unauthorized if login fails
        }
    }
}
