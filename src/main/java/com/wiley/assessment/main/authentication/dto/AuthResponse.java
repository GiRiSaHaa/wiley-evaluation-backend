package com.wiley.assessment.main.authentication.dto;

/**
 * DTO class for return auth response
 */
public class AuthResponse {
    private final String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
