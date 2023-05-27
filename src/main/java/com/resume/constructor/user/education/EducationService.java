package com.resume.constructor.user.education;

import java.util.List;

import com.resume.constructor.exception.EducationNotExistException;
import com.resume.constructor.mappers.EducationMapper;
import com.resume.constructor.security.AuthService;
import com.resume.constructor.user.education.dto.CreateEducationDto;
import com.resume.constructor.user.education.dto.UpdateEducationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EducationService {

    private final AuthService authService;
    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    public List<Education> getAllByCurrentUser() {
        Long userId = authService.getCurrentUserId();
        return educationRepository.getAllByUserIdOrderByYearOfGraduationDesc(userId);
    }

    public Education saveNew(CreateEducationDto createEducationDto) {
        Education education = educationMapper.toEducation(createEducationDto);
        Long userId = authService.getCurrentUserId();
        education.setUserId(userId);
        return educationRepository.save(education);
    }

    public Education update(UpdateEducationDto updateEducationDto) {
        boolean existsById = educationRepository.existsById(updateEducationDto.getId());
        if (!existsById) {
            throw new EducationNotExistException(updateEducationDto.getId());
        }
        Education education = educationMapper.toEducation(updateEducationDto);
        Long userId = authService.getCurrentUserId();
        education.setUserId(userId);
        return educationRepository.save(education);
    }

    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

}
