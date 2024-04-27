package com.HCSBackEnd.HCS.Back.End.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.User;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.UserDto;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.UserService;
import org.apache.commons.codec.binary.Base32;
import java.security.SecureRandom;
import com.HCSBackEnd.HCS.Back.End.security.SecurityUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

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
                .secret(SecurityUtil.generateSecretKey())
                .isUsing2FA(false)
                .build();
        return userRepository.save(user);
    }

    @Override
    public User loginUser(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin());
        if (user != null) {
            // Compare the hashed password from the database with the raw password entered
            // by the user
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

    public static String APP_NAME = "SpringRegistration";
    public static String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";

    @Override
    public String generateQRUrl(User user) throws UnsupportedEncodingException {
        return QR_PREFIX + URLEncoder.encode(String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", APP_NAME,
                user.getEmail(), user.getSecret(), APP_NAME), "UTF-8");
    }

    @Override
    public User updateUser2FA(boolean use2FA) {
        final Authentication curAuth = SecurityContextHolder.getContext()
                .getAuthentication();
        User currentUser = (User) curAuth.getPrincipal();
        currentUser.setIsUsing2FA(use2FA);
        currentUser = userRepository.save(currentUser);
        final Authentication auth = new UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(),
                curAuth.getAuthorities());
        SecurityContextHolder.getContext()
                .setAuthentication(auth);
        return currentUser;
    }

}
