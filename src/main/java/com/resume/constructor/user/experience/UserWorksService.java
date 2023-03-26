package com.resume.constructor.user.experience;

import java.util.List;

import com.resume.constructor.exception.WorkDataNotExistException;
import com.resume.constructor.mappers.WorkMapper;
import com.resume.constructor.security.AuthService;
import com.resume.constructor.user.experience.dto.CreateWorkDataDto;
import com.resume.constructor.user.experience.dto.UpdateWorkDataDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserWorksService {

    private final AuthService authService;
    private final UserWorksRepository userWorksRepository;
    private final WorkMapper workMapper;

    public List<Work> getAllByCurrentUser() {
        Long userId = authService.getCurrentUserId();
        return userWorksRepository.getAllByUserId(userId);
    }

    public Work saveNew(CreateWorkDataDto createWorkDataDto) {
        Work work = workMapper.toWorkData(createWorkDataDto);
        Long userId = authService.getCurrentUserId();
        work.setUserId(userId);
        return userWorksRepository.save(work);
    }

    public Work update(UpdateWorkDataDto updateWorkDataDto) {
        boolean existsById = userWorksRepository.existsById(updateWorkDataDto.getId());
        if (!existsById) {
            throw new WorkDataNotExistException(updateWorkDataDto.getId());
        }
        Work work = workMapper.toWorkData(updateWorkDataDto);
        Long userId = authService.getCurrentUserId();
        work.setUserId(userId);
        return userWorksRepository.save(work);
    }

    public void delete(Long id) {
        userWorksRepository.deleteById(id);
    }

}
