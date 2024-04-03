package com.HCSBackEnd.HCS.Back.End.security.config;

@Component
public class TwoFADetailsSource implements
    AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

  @Override
  public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
    return new CustomWebAuthenticationDetails(context);
  }
}