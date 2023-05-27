package com.resume.constructor.api;

import com.resume.constructor.user.UserService;
import com.resume.constructor.user.dto.UserAllDataDto;
import com.resume.constructor.user.personal.dto.UserAllPersonalFieldsDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @Operation(summary = "Get all personal data of current authenticated user")
    public UserAllPersonalFieldsDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PatchMapping("partialUpdate")
    @Operation(summary = "Partial update personal data of current authenticated user")
    public void partialUpdate(@RequestBody UserAllPersonalFieldsDto allFieldsDto) {
        userService.partialUpdate(allFieldsDto);
    }

    @GetMapping("allData")
    @Operation(summary = "Get full user data of current authenticated user including all related entities")
    public UserAllDataDto userAllDataDto(){
        return userService.getAllDataOfCurrentUser();
    }

    @DeleteMapping("removeAll")
    @Operation(summary = "Remove all user personal data")
    public void removeAll(){
        userService.removeAllDataOfCurrentUser();
    }

}
