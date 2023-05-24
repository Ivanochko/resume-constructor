package com.resume.constructor.api;

import java.util.List;
import java.util.Map;

import com.resume.constructor.user.skills.Skill;
import com.resume.constructor.user.skills.SkillLevel;
import com.resume.constructor.user.skills.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users/skills")
public class SkillsController {

    private final SkillService skillService;

    @GetMapping
    @Operation(summary = "Get all skills by current authenticated user")
    public List<Skill> getAllByCurrentUser() {
        return skillService.getAllByCurrentUser();
    }

    @PutMapping
    @Operation(summary = "Update all skills for current authenticated user by passed skills")
    public List<Skill> updateAll(@RequestBody Map<String, SkillLevel> skills) {
        return skillService.updateAll(skills);
    }

}
