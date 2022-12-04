package com.resume.constructor.user;

import java.util.List;

import com.resume.constructor.user.dto.UserDataDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDataDto> getUsers() {
        return userService.getUsers();
    }

}
