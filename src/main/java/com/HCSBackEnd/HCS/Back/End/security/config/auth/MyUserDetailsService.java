package com.HCSBackEnd.HCS.Back.End.security.config.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

  private final PasswordEncoder passwordEncoder;

  public MyUserDetailsService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    // Just for demonstration - normally you would look up the user in the database
    if (!username.equals("user")) {
      throw new UsernameNotFoundException("User not found");
    }
    return new User("user", passwordEncoder.encode("password"), new ArrayList<>());
  }
}
