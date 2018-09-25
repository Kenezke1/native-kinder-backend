package com.codecool.kinder.repository;

import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    @Override
    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);
}
