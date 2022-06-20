package com.ceydog.hw3ceydas.jwt.dto;

import lombok.Data;

@Data
public class JwtLoginRequestDto {

    private String username;
    private String password;
}
