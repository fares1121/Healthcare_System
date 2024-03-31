package com.HCSBackEnd.HCS.AccessControll;

import java.util.*;

public class DatabaseAccessController {
  private AccessControlDirectory accessControlDirectory;

  public DatabaseAccessController() {
    this.accessControlDirectory = new AccessControlDirectory();
  }

  // Grant access to database entities based on user role
  public void grantAccess(User user) {
    Role role = user.getRole();
    switch (role) {
      case DOCTOR:
        accessControlDirectory.grantAccess(user, "appointments");
        accessControlDirectory.grantAccess(user, "medical_records");
        accessControlDirectory.grantAccess(user, "prescriptions");
        break;
      case PATIENT:
        accessControlDirectory.grantAccess(user, "medical_records");
        accessControlDirectory.grantAccess(user, "appointments");
        accessControlDirectory.grantAccess(user, "prescriptions");
        break;
      case ADMIN:
        // Grant full access to all entities for admins
        break;
      case STAFF:
        accessControlDirectory.grantAccess(user, "appointments");
        // Additional access for staff as needed
        break;
      default:
        break;
    }

  }

    // Revoke access to database entities based on user role
  public void revokeAccess(User user) {
    // Implement as needed
  }

  // Check if a user has access to a specific entity
  public boolean hasAccess(User user, String entity) {
    return accessControlDirectory.hasAccess(user, entity);
  }

  // List all entities a user has access to
  public Set<String> listUserEntities(User user) {
    return accessControlDirectory.listUserEntities(user);
  }

}
