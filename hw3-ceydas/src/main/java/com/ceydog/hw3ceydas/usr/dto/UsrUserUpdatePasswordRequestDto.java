package com.ceydog.hw3ceydas.usr.dto;

import lombok.Data;

@Data
public class UsrUserUpdatePasswordRequestDto {

    private String username;
    private String newPassword;
    private String oldPassword;
}
