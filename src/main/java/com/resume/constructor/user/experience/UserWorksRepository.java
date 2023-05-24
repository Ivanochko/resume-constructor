package com.resume.constructor.user.experience;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWorksRepository extends JpaRepository<Work, Long> {

    List<Work> getAllByUserIdOrderByEndDateDesc(Long userId);

}
