package com.resume.constructor.user.skills;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> getAllByUserIdOrderBySkillLevel(Long userId);

    Optional<Skill> getByNameAndUserId(String name, Long userId);

}
