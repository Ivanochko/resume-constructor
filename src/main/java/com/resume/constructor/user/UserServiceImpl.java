package com.resume.constructor.user;

import java.util.List;
import java.util.stream.Collectors;

import com.resume.constructor.mappers.UserMapper;
import com.resume.constructor.user.dto.UserDataDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDataDto> getUsers() {
        return userRepository.findAll().stream()
                                       .map(userMapper::toDataDto)
                                       .collect(Collectors.toList());
    }

}
