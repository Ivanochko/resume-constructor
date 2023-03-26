package com.resume.constructor.mappers;

import com.resume.constructor.user.auth.LoginUserDetails;
import com.resume.constructor.user.auth.UserAuthEntity;
import com.resume.constructor.user.dto.UserAllDataDto;
import com.resume.constructor.user.personal.dto.UserAllPersonalFieldsDto;
import com.resume.constructor.user.auth.dto.UserLoginDto;
import com.resume.constructor.user.auth.dto.UserRegisterDto;
import com.resume.constructor.user.personal.UserPersonalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "email", target = "username")
    LoginUserDetails toDetails(UserAuthEntity userData);

    UserLoginDto toLogin(UserRegisterDto userRegisterDto);

    UserAuthEntity toData(UserRegisterDto userRegisterDto);

    UserPersonalEntity toPersonalData(UserRegisterDto userRegisterDto, Long id);

    UserAllPersonalFieldsDto toAllPersonalFields(UserAuthEntity userAuthEntity,
                                                 UserPersonalEntity userPersonalEntity);

    UserAllDataDto toAllData(UserAllPersonalFieldsDto personalFieldsDto);

}
