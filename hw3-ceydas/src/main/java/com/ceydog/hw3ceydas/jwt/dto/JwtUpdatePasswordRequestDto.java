package com.ceydog.hw3ceydas.jwt.dto;

import lombok.Data;

@Data
public class JwtUpdatePasswordRequestDto {
    private String username;
    private String newPassword;
    private String oldPassword;
}
