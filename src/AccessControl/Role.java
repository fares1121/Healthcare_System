package com.HCSBackEnd.HCS.AccessControll;

public enum Role {
  DOCTOR, PATIENT, ADMIN, STAFF;
    
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
  
}
