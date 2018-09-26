package com.codecool.kinder.repository;

import com.codecool.kinder.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByUserId(Integer userId);

    @Override
    Optional<Profile> findById(Integer integer);
}
