package com.ceydog.hw3ceydas.usr.dto;

import lombok.Data;

@Data
public class UsrUserDto {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String oldPassword;
}
