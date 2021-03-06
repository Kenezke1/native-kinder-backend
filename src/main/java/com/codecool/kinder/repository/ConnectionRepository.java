package com.codecool.kinder.repository;

import com.codecool.kinder.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<Connection, Integer> {

    @Query(value = "SELECT * FROM connections WHERE user_from = ?1 " +
            "AND status = 'RIGHT' OR status = 'SUPER';",
            nativeQuery = true)
    List<Connection> findAllForUser(Integer userId);

    @Query(value = "SELECT DISTINCT LEAST(conn1.user_from,conn2.user_to) as User1, " +
            "GREATEST(conn1.user_from,conn2.user_to) as User2, " +
            "conn1.id,conn1.user_from,conn1.user_to,conn1.status " +
            "FROM connections as conn1 INNER JOIN connections as conn2 ON " +
            "conn1.user_to = conn2.user_from AND conn1.user_from = conn2.user_to " +
            "JOIN users on conn1.user_from = users.id " +
            "WHERE conn1.status = 'RIGHT' AND conn2.status = 'RIGHT' " +
            "AND (conn1.user_from = ?1 OR conn1.user_to = ?1);",nativeQuery = true)
    List<Connection> findMyConnections(Integer userId);


    @Override
    Optional<Connection> findById(Integer integer);
}
