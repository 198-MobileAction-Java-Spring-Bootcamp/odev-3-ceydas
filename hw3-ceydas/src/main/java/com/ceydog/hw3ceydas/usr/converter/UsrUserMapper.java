package com.ceydog.hw3ceydas.usr.converter;

import com.ceydog.hw3ceydas.usr.dto.UsrUserDto;
import com.ceydog.hw3ceydas.usr.dto.UsrUserSaveRequestDto;
import com.ceydog.hw3ceydas.usr.dto.UsrUserUpdatePasswordRequestDto;
import com.ceydog.hw3ceydas.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUserDto convertToUsrUserDto(UsrUser usrUser);

    UsrUser convertUsrUserDtoToUsrUser(UsrUserDto usrUserDto);

    UsrUser convertToUsrUser(UsrUserUpdatePasswordRequestDto usrUserUpdateRequestDto);

    List<UsrUserDto> convertToUsrUserDtoList(List<UsrUser> usrUserList);

    UsrUser convertToUsrUser(UsrUserSaveRequestDto usrUserSaveRequestDto);
}
