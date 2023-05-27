package com.resume.constructor.user;

import com.resume.constructor.user.dto.UserAllDataDto;
import com.resume.constructor.user.personal.dto.UserAllPersonalFieldsDto;

public interface UserService {

    void partialUpdate(UserAllPersonalFieldsDto userAllPersonalFieldsDto);

    UserAllPersonalFieldsDto getCurrentUser();

    UserAllDataDto getAllDataOfCurrentUser();

    void removeAllDataOfCurrentUser();


}
