package com.HCSBackEnd.HCS.Back.End.security.config;

public class TwoFADetails extends WebAuthenticationDetails {

  private String verificationCode;

  public CustomWebAuthenticationDetails(HttpServletRequest request) {
    super(request);
    verificationCode = request.getParameter("code");
  }

  public String getVerificationCode() {
    return verificationCode;
  }
}