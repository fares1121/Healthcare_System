package com.HCSBackEnd.HCS.Back.End.security.dtos;

public record SignUpDto (String firstName, String lastName, String login, char[] password) { }
