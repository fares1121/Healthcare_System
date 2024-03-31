package com.HCSBackEnd.HCS.AccessControll;

import java.util.*;

public class AccessControlList {
  private Map<String, List<ACLEntry>> aclMap;

  public AccessControlList() {
    this.aclMap = new HashMap<>();
  }

  // Add an ACL entry for a database entity
  public void addACLEntry(String entity, ACLEntry entry) {
    aclMap.computeIfAbsent(entity, k -> new ArrayList<>()).add(entry);
  }

  // Remove an ACL entry for a database entity
  public void removeACLEntry(String entity, ACLEntry entry) {
    List<ACLEntry> aclList = aclMap.get(entity);
    
    if (aclList != null) {
      aclList.remove(entry);
    }

  }

  // Check if a subject has a specific access right for a database entity
  public boolean hasAccess(String entity, String subject, AccessRight accessRight) {
    List<ACLEntry> aclList = aclMap.get(entity);
    
    if (aclList != null) {
            
      for (ACLEntry entry : aclList) {
                
        if (entry.matches(subject) && entry.getAccessRights().contains(accessRight)) {
          return true;
        }
            
      }
        
    }
        
    return false;
  }

    // Define ACL entry class
  public static class ACLEntry {
    private String subject;
    private Set<AccessRight> accessRights;

    public ACLEntry(String subject, AccessRight... accessRights) {
      this.subject = subject;
      this.accessRights = new HashSet<>(Arrays.asList(accessRights));
    }

    public String getSubject() {
      return subject;
    }

    public Set<AccessRight> getAccessRights() {
      return accessRights;
    }

    // Check if the entry matches a subject
    public boolean matches(String subject) {
      return this.subject.equals(subject);
    }
    
  }

}
