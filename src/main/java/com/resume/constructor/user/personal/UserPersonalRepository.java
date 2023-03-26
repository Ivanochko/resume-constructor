package com.resume.constructor.user.personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPersonalRepository extends JpaRepository<UserPersonalEntity, Long> {
}
