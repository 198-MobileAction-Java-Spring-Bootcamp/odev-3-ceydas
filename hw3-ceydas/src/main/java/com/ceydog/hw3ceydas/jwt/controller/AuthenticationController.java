package com.ceydog.hw3ceydas.jwt.controller;


import com.ceydog.hw3ceydas.jwt.dto.JwtLoginRequestDto;
import com.ceydog.hw3ceydas.jwt.service.AuthenticationService;
import com.ceydog.hw3ceydas.usr.dto.UsrUserDto;
import com.ceydog.hw3ceydas.usr.dto.UsrUserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity save(@Valid @RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto){

        UsrUserDto usrUserDto = authenticationService.register(usrUserSaveRequestDto);

        return ResponseEntity.ok(usrUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JwtLoginRequestDto jwtLoginRequestDto){

        String login = authenticationService.login(jwtLoginRequestDto);

        return ResponseEntity.ok(login);
    }
}
