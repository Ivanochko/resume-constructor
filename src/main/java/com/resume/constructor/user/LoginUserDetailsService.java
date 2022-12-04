package com.resume.constructor.user;

import com.resume.constructor.exception.EmailNotFoundException;
import com.resume.constructor.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByEmail(username);
    }

    public LoginUserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        UserData userData = userRepository.getByEmail(email).orElseThrow(
                () -> new EmailNotFoundException(email)
        );
        return userMapper.toDetails(userData);
    }
}
