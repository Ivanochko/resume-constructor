package com.resume.constructor.mappers;

import com.resume.constructor.user.LoginUserDetails;
import com.resume.constructor.user.UserData;
import com.resume.constructor.user.dto.UserDataDto;
import com.resume.constructor.user.dto.UserLoginDto;
import com.resume.constructor.user.dto.UserRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "email", target = "username")
    LoginUserDetails toDetails(UserData userData);

    UserLoginDto toLogin(UserRegisterDto userRegisterDto);

    UserData toData(UserRegisterDto userRegisterDto);

    UserDataDto toDataDto(UserData userRegisterDto);

}
