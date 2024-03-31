package com.HCSBackEnd.HCS.AccessControll;

import jakarta.persistence.Entity;

@Entity

public class User {
  private long userId;
  private Role role;

  public User(long userId, Role role) {
    this.userId = userId;
    this.role = role;
  }

  public long getUserId() {
    return userId;
  }

  public Role getRole() {
    return role;
  }

}
  
