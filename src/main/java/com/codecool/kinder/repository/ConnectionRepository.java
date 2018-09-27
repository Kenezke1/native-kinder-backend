package com.codecool.kinder.repository;

import com.codecool.kinder.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConnectionRepository extends JpaRepository<Connection, Integer> {

    @Query(value = "SELECT * FROM connections WHERE user_from = ?1 " +
            "AND status = 'RIGHT' OR status = 'SUPER';",
            nativeQuery = true)
    List<Connection> findAllForUser(Integer userId);

    @Query(value = "SELECT * FROM connections WHERE user_from = ?1 and user_to IN(SELECT user_from FROM connections WHERE user_to = ?1) AND user_to IN(SELECT user_from FROM connections WHERE user_to = ?1)",nativeQuery = true)
    List<Connection> findAllMatch(Integer userId);
}
