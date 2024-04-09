package com.HCSBackEnd.HCS.Back.End.security.config.auth;

public interface UserService {
    User registerUser(SignUpDto signUpDto);
    User loginUser(CredentialsDto credentialsDto);
    UserDto getUserInfo(String login);
}
