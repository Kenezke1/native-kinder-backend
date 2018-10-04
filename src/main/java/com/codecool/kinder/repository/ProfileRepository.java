package com.codecool.kinder.repository;

import com.codecool.kinder.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByUserId(Integer userId);

    @Override
    Optional<Profile> findById(Integer integer);
}
