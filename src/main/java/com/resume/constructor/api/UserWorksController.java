package com.resume.constructor.api;

import java.util.List;

import com.resume.constructor.user.experience.Work;
import com.resume.constructor.user.experience.dto.CreateWorkDataDto;
import com.resume.constructor.user.experience.dto.UpdateWorkDataDto;
import com.resume.constructor.user.experience.UserWorksService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users/works")
public class UserWorksController {

    private final UserWorksService userWorksService;

    @GetMapping
    @Operation(summary = "Get all experience data by current authenticated user")
    public List<Work> getAllByCurrentUser() {
        return userWorksService.getAllByCurrentUser();
    }

    @PostMapping
    @Operation(summary = "Create new experience data")
     public Work createNew(@RequestBody CreateWorkDataDto createWorkDataDto) {
        return userWorksService.saveNew(createWorkDataDto);
    }

    @PutMapping
    @Operation(summary = "Update passed experience data")
    public Work update(@RequestBody UpdateWorkDataDto updateWorkDataDto) {
        return userWorksService.update(updateWorkDataDto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete existing experience data by given id")
    public void delete(@PathVariable Long id) {
        userWorksService.delete(id);
    }

}
