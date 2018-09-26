package com.codecool.kinder.repository;

import com.codecool.kinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByIdAndEnabledTrue(Integer id);

    Optional<User> findByEmailAndEnabledTrue(String email);
}
