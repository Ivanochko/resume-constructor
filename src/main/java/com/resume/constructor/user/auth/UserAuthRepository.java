package com.resume.constructor.user.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthEntity, Long> {

    Boolean existsByEmail(String email);

    Optional<UserAuthEntity> getByEmail(String email);

}
