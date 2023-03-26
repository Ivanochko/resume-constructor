package com.resume.constructor.api;

import com.resume.constructor.user.UserService;
import com.resume.constructor.user.dto.UserAllDataDto;
import com.resume.constructor.user.personal.dto.UserAllPersonalFieldsDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping("current")
    public UserAllPersonalFieldsDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PatchMapping("partialUpdate")
    public void partialUpdate(@RequestBody UserAllPersonalFieldsDto allFieldsDto) {
        userService.partialUpdate(allFieldsDto);
    }

    @GetMapping("allData")
    public UserAllDataDto userAllDataDto(){
        return userService.getAllDataOfCurrentUser();
    }

}
