package com.boots.users;

public enum UserRole {
    ADMIN("ADMIN"),
    USER_ROLE("USER");


    public String getRole() {
        return role;
    }

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
