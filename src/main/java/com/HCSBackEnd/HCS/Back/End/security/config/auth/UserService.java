package com.HCSBackEnd.HCS.Back.End.security.config.auth;

import java.io.UnsupportedEncodingException;

public interface UserService {
    User registerUser(SignUpDto signUpDto);

    User loginUser(CredentialsDto credentialsDto);

    UserDto getUserInfo(String login);

    String generateQRUrl(User user) throws UnsupportedEncodingException;

    User updateUser2FA(boolean use2FA);
}
