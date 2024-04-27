package com.HCSBackEnd.HCS.Back.End.security.google2FA;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

  private static final long serialVersionUID = 1L;

  private final String verificationCode;

  public CustomWebAuthenticationDetails(HttpServletRequest request) {
    super(request);
    verificationCode = request.getParameter("code");
  }

  public String getVerificationCode() {
    return verificationCode;
  }
}