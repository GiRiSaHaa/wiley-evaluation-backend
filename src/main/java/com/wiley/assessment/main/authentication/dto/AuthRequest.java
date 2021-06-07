package com.wiley.assessment.main.authentication.dto;

import lombok.Data;

/**
 * DTO class for parse auth credential
 */
@Data
public class AuthRequest {
    private String username;
    private String password;
}
