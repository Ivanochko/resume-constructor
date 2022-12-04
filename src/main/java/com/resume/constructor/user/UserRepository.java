package com.resume.constructor.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {

    Boolean existsByEmail(String email);

    Optional<UserData> getByEmail(String email);

}
