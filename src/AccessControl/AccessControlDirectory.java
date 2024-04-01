package com.HCSBackEnd.HCS.AccessControll;

import java.util.*;

public class AccessControlDirectory {
  private Map<Long, Set<String>> userDirectories;

  public AccessControlDirectory() {
    this.userDirectories = new HashMap<>();
  }

  // Grant access to a specific entity for a user
  public void grantAccess(User user, String entity) {
    long userId = user.getUserId();
    Set<String> directory = userDirectories.computeIfAbsent(userId, k -> new HashSet<>());
    directory.add(entity);
  }

  // Revoke access to a specific entity for a user
  public void revokeAccess(User user, String entity) {
    long userId = user.getUserId();
    Set<String> directory = userDirectories.get(userId);
        
    if (directory != null) {
            directory.remove(entity);
    }
    
  }

  // Check if a user has access to a specific entity
  public boolean hasAccess(User user, String entity) {
    long userId = user.getUserId();
    Set<String> directory = userDirectories.get(userId);
    return directory != null && directory.contains(entity);
  }

  // List all entities a user has access to
  public Set<String> listUserEntities(User user) {
    long userId = user.getUserId();
    Set<String> directory = userDirectories.get(userId);
    return directory != null ? directory : Collections.emptySet();
  }

}
