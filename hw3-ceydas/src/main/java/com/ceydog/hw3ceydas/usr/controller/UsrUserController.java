package com.ceydog.hw3ceydas.usr.controller;

import com.ceydog.hw3ceydas.usr.dto.UsrUserDto;
import com.ceydog.hw3ceydas.usr.dto.UsrUserSaveRequestDto;
import com.ceydog.hw3ceydas.usr.service.UsrUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsrUserController {

    private final UsrUserService usrUserService;

    @Operation(
            tags = "User Controller",
            description = "Gets all users"
    )
    @GetMapping
    public ResponseEntity<List<UsrUserDto>> findAll(){

        List<UsrUserDto> usrUserDtoList = usrUserService.findAll();

        return ResponseEntity.ok(usrUserDtoList);
    }

    @Operation(
            tags = "User Controller",
            description = "Saves new user"
    )
    @PostMapping
    public ResponseEntity<UsrUserDto> save(@Valid @RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto){

        UsrUserDto usrUserDto = usrUserService.save(usrUserSaveRequestDto);

        return ResponseEntity.ok(usrUserDto);
    }


}
