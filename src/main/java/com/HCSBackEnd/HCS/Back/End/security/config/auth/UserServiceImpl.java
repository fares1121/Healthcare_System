package com.HCSBackEnd.HCS.Back.End.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(SignUpDto signUpDto) {
        // Convert SignUpDto to User entity
        User user = User.builder()
                .firstName(signUpDto.getFirstName())
                .lastName(signUpDto.getLastName())
                .login(signUpDto.getLogin())
                .password(passwordEncoder.encode(new String(signUpDto.getPassword())))
                .email(signUpDto.getEmail())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User loginUser(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin());
        if (user != null) {
            // Hash the password provided in credentialsDto for comparison
            String hashedPassword = passwordEncoder.encode(new String(credentialsDto.getPassword()));

            // Compare the hashed passwords
            if (passwordEncoder.matches(hashedPassword, user.getPassword())) {
                return user; // Return the user if passwords match
            }
        }
        return null; // Return null if user not found or passwords don't match
    }

    @Override
    public UserDto getUserInfo(String login) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return UserDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .login(user.getLogin())
                    .email(user.getEmail())
                    .build();
        }
        return null; // User not found
    }
}

