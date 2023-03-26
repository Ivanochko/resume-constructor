package com.resume.constructor.user;

import java.util.List;

import com.resume.constructor.mappers.UserMapper;
import com.resume.constructor.security.AuthService;
import com.resume.constructor.user.auth.UserAuthEntity;
import com.resume.constructor.user.auth.UserAuthRepository;
import com.resume.constructor.user.dto.UserAllDataDto;
import com.resume.constructor.user.education.Education;
import com.resume.constructor.user.education.EducationService;
import com.resume.constructor.user.experience.UserWorksService;
import com.resume.constructor.user.experience.Work;
import com.resume.constructor.user.personal.dto.UserAllPersonalFieldsDto;
import com.resume.constructor.user.personal.UserPersonalEntity;
import com.resume.constructor.user.personal.UserPersonalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthService authService;
    private final EducationService educationService;
    private final UserWorksService worksService;
    private final UserAuthRepository userAuthRepository;
    private final UserPersonalRepository userPersonalRepository;
    private final UserMapper userMapper;

    @Override
    public UserAllPersonalFieldsDto getCurrentUser(){
        Long userId = authService.getCurrentUserId();
        UserAuthEntity userAuth = userAuthRepository.getReferenceById(userId);
        UserPersonalEntity userPersonal = userPersonalRepository.getReferenceById(userId);
        return userMapper.toAllPersonalFields(userAuth, userPersonal);
    }

    @Override
    public void partialUpdate(UserAllPersonalFieldsDto userAllPersonalFieldsDto) {
        Long userId = authService.getCurrentUserId();
        partialUpdateAuthEntity(userAllPersonalFieldsDto, userId);
        partialUpdatePersonalEntity(userAllPersonalFieldsDto, userId);
    }

    @Override
    public UserAllDataDto getAllDataOfCurrentUser() {
        List<Work> works = worksService.getAllByCurrentUser();
        List<Education> educations = educationService.getAllByCurrentUser();
        UserAllPersonalFieldsDto personalFieldsDto = getCurrentUser();
        UserAllDataDto userAllDataDto = userMapper.toAllData(personalFieldsDto);
        userAllDataDto.setEducations(educations);
        userAllDataDto.setWorks(works);
        return userAllDataDto;
    }

    private void partialUpdateAuthEntity(UserAllPersonalFieldsDto userAllPersonalFieldsDto, Long userId) {
        String email = userAllPersonalFieldsDto.getEmail();
        if (email != null && !email.isBlank()) {
            UserAuthEntity userAuth = userAuthRepository.getReferenceById(userId);
            userAuth.setEmail(email);
            userAuthRepository.save(userAuth);
        }
    }

    private void partialUpdatePersonalEntity(UserAllPersonalFieldsDto userAllPersonalFieldsDto, Long userId) {
        UserPersonalEntity userPersonal = userPersonalRepository.getReferenceById(userId);
        if (userAllPersonalFieldsDto.getFirstName() != null) {
            userPersonal.setFirstName(userAllPersonalFieldsDto.getFirstName());
        }
        if (userAllPersonalFieldsDto.getLastName() != null) {
            userPersonal.setLastName(userAllPersonalFieldsDto.getLastName());
        }
        if (userAllPersonalFieldsDto.getTitle() != null) {
            userPersonal.setTitle(userAllPersonalFieldsDto.getTitle());
        }
        if (userAllPersonalFieldsDto.getSex() != null) {
            userPersonal.setSex(userAllPersonalFieldsDto.getSex());
        }
        if (userAllPersonalFieldsDto.getLocation() != null) {
            userPersonal.setLocation(userAllPersonalFieldsDto.getLocation());
        }
        if (userAllPersonalFieldsDto.getSummary() != null) {
            userPersonal.setSummary(userAllPersonalFieldsDto.getSummary());
        }
        if (userAllPersonalFieldsDto.getPhoneNumber() != null) {
            userPersonal.setPhoneNumber(userAllPersonalFieldsDto.getPhoneNumber());
        }
        if (userAllPersonalFieldsDto.getContacts() != null) {
            userPersonal.setContacts(userAllPersonalFieldsDto.getContacts());
        }
        userPersonalRepository.save(userPersonal);
    }

}
