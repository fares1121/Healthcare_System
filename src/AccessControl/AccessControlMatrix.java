package com.HCSBackEnd.HCS.AccessControll;

import java.util.*;

public class AccessControlMatrix {
  private Map<User, Map<String, Set<AccessRight>>> accessMatrix;

    public AccessControlMatrix() {
        this.accessMatrix = new HashMap<>();
    }

    // Grant access rights to a user for a specific entity
    public void grantAccess(User user, String entity, AccessRight... accessRights) {
        accessMatrix.computeIfAbsent(user, k -> new HashMap<>())
                    .computeIfAbsent(entity, k -> new HashSet<>())
                    .addAll(Arrays.asList(accessRights));
    }

    // Revoke access rights from a user for a specific entity
    public void revokeAccess(User user, String entity, AccessRight... accessRights) {
        Map<String, Set<AccessRight>> userAccess = accessMatrix.get(user);
        if (userAccess != null) {
            Set<AccessRight> entityAccess = userAccess.get(entity);
            if (entityAccess != null) {
                entityAccess.removeAll(Arrays.asList(accessRights));
                if (entityAccess.isEmpty()) {
                    userAccess.remove(entity);
                }
            }
        }
    }

    // Check if a user has a specific access right for a specific entity
    public boolean hasAccess(User user, String entity, AccessRight accessRight) {
        Map<String, Set<AccessRight>> userAccess = accessMatrix.get(user);
        if (userAccess != null) {
            Set<AccessRight> entityAccess = userAccess.get(entity);
            return entityAccess != null && entityAccess.contains(accessRight);
        }
        return false;
    }

    // List all access rights for a user and entity
    public Set<AccessRight> listAccessRights(User user, String entity) {
        Map<String, Set<AccessRight>> userAccess = accessMatrix.get(user);
        return userAccess != null ? userAccess.getOrDefault(entity, Collections.emptySet()) : Collections.emptySet();
    }
}
