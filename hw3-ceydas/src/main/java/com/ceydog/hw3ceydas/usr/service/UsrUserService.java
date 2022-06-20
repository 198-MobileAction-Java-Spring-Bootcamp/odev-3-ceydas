package com.ceydog.hw3ceydas.usr.service;

import com.ceydog.hw3ceydas.gen.enums.GenErrorMessage;
import com.ceydog.hw3ceydas.gen.service.BaseEntityService;
import com.ceydog.hw3ceydas.usr.converter.UsrUserMapper;
import com.ceydog.hw3ceydas.usr.dao.UsrUserDao;
import com.ceydog.hw3ceydas.usr.dto.UsrUserDto;
import com.ceydog.hw3ceydas.usr.dto.UsrUserSaveRequestDto;
import com.ceydog.hw3ceydas.usr.dto.UsrUserUpdatePasswordRequestDto;
import com.ceydog.hw3ceydas.usr.entity.UsrUser;
import com.ceydog.hw3ceydas.usr.service.entityservice.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UsrUserService{

    private final UsrUserEntityService usrUserEntityService;
    private final PasswordEncoder passwordEncoder;

    public List<UsrUserDto> findAll() {

        List<UsrUser> usrUserList = usrUserEntityService.findAll();

        List<UsrUserDto> usrUserDtoList = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUserList);

        return usrUserDtoList;
    }

    public UsrUserDto save(UsrUserSaveRequestDto usrUserSaveRequestDto) {

        if (usrUserSaveRequestDto == null){
            throw new RuntimeException(GenErrorMessage.PARAMETER_CANNOT_BE_NULL.getMessage());
        }

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserSaveRequestDto);

        String password = passwordEncoder.encode(usrUser.getPassword());
        usrUser.setPassword(password);
        usrUser = usrUserEntityService.save(usrUser);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    public UsrUserDto findById(Long id) {

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    public void delete(Long id) {

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        usrUserEntityService.delete(usrUser);
    }

    public UsrUserDto update(UsrUserUpdatePasswordRequestDto usrUserUpdateRequestDto) {

        String username = usrUserUpdateRequestDto.getUsername();

        boolean isExist = usrUserEntityService.existsByUsername(username);
        if (!isExist){
            throw new RuntimeException(GenErrorMessage.USER_DOES_NOT_EXIST.getMessage());
        }

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserUpdateRequestDto);

        String password = passwordEncoder.encode(usrUser.getPassword());
        usrUser.setPassword(password);
        usrUser = usrUserEntityService.save(usrUser);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }
}
