package com.HCSBackEnd.HCS.AccessControll;

public class ReferenceMonitor {
  private AccessControlList acl;

  public ReferenceMonitor() {
    this.acl = new AccessControlList();
  }

  // Add an ACL entry for a database entity
  public void addACLEntry(String entity, AccessControlList.ACLEntry entry) {
    acl.addACLEntry(entity, entry);
  }

  // Remove an ACL entry for a database entity
  public void removeACLEntry(String entity, AccessControlList.ACLEntry entry) {
    acl.removeACLEntry(entity, entry);
  }

  // Check if a subject has a specific access right for a database entity
  public boolean hasAccess(String entity, String subject, AccessRight accessRight) {
    return acl.hasAccess(entity, subject, accessRight);
  }

  // Method to perform access control decision
  public boolean authorize(String entity, String subject, AccessRight accessRight) {
    
    if (hasAccess(entity, subject, accessRight)) {
      System.out.println("Access granted: " + subject + " has " + accessRight + " access to " + entity);
      return true;
    } else {
      System.out.println("Access denied: " + subject + " does not have " + accessRight + " access to " + entity);
      return false;
    }
    
  }

  // Main method for testing
  public static void main(String[] args) {
    // Create a new instance of the ReferenceMonitor
    ReferenceMonitor referenceMonitor = new ReferenceMonitor();

    // Define some ACL entries
    AccessControlList.ACLEntry adminEntry = new AccessControlList.ACLEntry("admin", AccessRight.READ, AccessRight.WRITE);
    AccessControlList.ACLEntry userEntry = new AccessControlList.ACLEntry("user", AccessRight.READ);

    // Add ACL entries for database entities
    referenceMonitor.addACLEntry("medical_records", adminEntry);
    referenceMonitor.addACLEntry("appointments", adminEntry);
    referenceMonitor.addACLEntry("prescriptions", adminEntry);
    referenceMonitor.addACLEntry("medical_records", userEntry);
    referenceMonitor.addACLEntry("appointments", userEntry);
    referenceMonitor.addACLEntry("prescriptions", userEntry);

    // Perform access control decision
    referenceMonitor.authorize("medical_records", "admin", AccessRight.READ);
    referenceMonitor.authorize("medical_records", "user", AccessRight.WRITE);
  }

}
