package com.resume.constructor.user.skills;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.resume.constructor.security.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;
    private final AuthService authService;

    public List<Skill> getAllByCurrentUser() {
        Long userId = authService.getCurrentUserId();
        return skillRepository.getAllByUserIdOrderBySkillLevel(userId);
    }

    @Transactional
    public List<Skill> updateAll(Map<String, SkillLevel> skills) {
        Long userId = authService.getCurrentUserId();
        List<Skill> allByUserId = skillRepository.getAllByUserIdOrderBySkillLevel(userId);

        deleteSkills(skills, allByUserId);

        List<Skill> skillsToSave = prepareSkills(skills, allByUserId, userId);
        return skillRepository.saveAll(skillsToSave);
    }

    private void deleteSkills(Map<String, SkillLevel> skills,
                              List<Skill> allByUserId) {
        List<Skill> skillsToBeDeleted = allByUserId.stream()
                .filter(skill -> !skills.containsKey(skill.getName()))
                .collect(Collectors.toList());

        skillRepository.deleteAll(skillsToBeDeleted);
    }

    private List<Skill> prepareSkills(Map<String, SkillLevel> skills,
                                      List<Skill> allByUserId,
                                      Long userId) {
        Map<String, SkillLevel> skillsFromDb = toMap(allByUserId);
        List<Map.Entry<String, SkillLevel>> skillsToBeSaved = skills.entrySet().stream()
                .filter(entry -> skillNotSavedYet(entry, skillsFromDb))
                .collect(Collectors.toList());

        return toListWithIds(skillsToBeSaved, userId);
    }

    private Map<String, SkillLevel> toMap(List<Skill> skills) {
        return skills.stream()
                .collect(Collectors.toMap(Skill::getName, Skill::getSkillLevel));
    }

    private List<Skill> toListWithIds(List<Map.Entry<String, SkillLevel>> entries, Long userId) {
        return entries.stream()
                .map(entry -> toSkill(entry, userId))
                .map(skill -> checkIfExistInDbAndAddId(skill, userId))
                .collect(Collectors.toList());
    }

    private Skill toSkill(Map.Entry<String, SkillLevel> entry, Long userId) {
        return Skill.builder()
                .name(entry.getKey())
                .skillLevel(entry.getValue())
                .userId(userId)
                .build();
    }

    private Skill checkIfExistInDbAndAddId(Skill skill, Long userId) {
        skillRepository.getByNameAndUserId(skill.getName(), userId).ifPresent(value -> skill.setId(value.getId()));
        return skill;
    }

    private boolean skillNotSavedYet(Map.Entry<String, SkillLevel> entry,
                                     Map<String, SkillLevel> skillsFromDb) {
        String key = entry.getKey();
        return !skillsFromDb.containsKey(key) || !entry.getValue().equals(skillsFromDb.get(entry.getKey()));
    }

}
