package com.HCSBackEnd.HCS.Back.End.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.User;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.UserDto;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.UserService;

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
            // Compare the hashed password from the database with the raw password entered by the user
            if (passwordEncoder.matches(new String(credentialsDto.getPassword()), user.getPassword())) {
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

