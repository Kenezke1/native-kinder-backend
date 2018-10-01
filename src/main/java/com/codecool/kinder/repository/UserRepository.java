package com.codecool.kinder.repository;

import com.codecool.kinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByIdAndEnabledTrue(Integer id);

    Optional<User> findByEmailAndEnabledTrue(String email);

    @Query(value = "SELECT DISTINCT LEAST(conn1.user_from,conn2.user_to) as User1, \n" +
            "GREATEST(conn1.user_from,conn2.user_to) as User2,\n" +
            "users.id,users.email, users.given_name,users.family_name,users.image_url,users.enabled   \n" +
            "FROM connections as conn1 INNER JOIN connections as conn2 ON\n" +
            "conn1.user_to = conn2.user_from AND conn1.user_from = conn2.user_to \n" +
            "RIGHT JOIN users on conn1.user_from = users.id WHERE conn1.user_from is null OR conn1.user_from != ?1 \n" +
            "AND conn2.user_to != ?1",nativeQuery = true)
    List<User> findUserNotMatched(Integer userId);


    @Query(value = "SELECT DISTINCT LEAST(conn1.user_from,conn2.user_to) as User1," +
            " GREATEST(conn1.user_from,conn2.user_to) as User2," +
            "users.id,users.email, users.given_name,users.family_name,users.image_url," +
            "users.enabled   FROM connections as conn1 INNER JOIN connections as conn2 ON " +
            "conn1.user_to = conn2.user_from AND conn1.user_from = conn2.user_to " +
            "JOIN users on conn1.user_from = users.id " +
            "WHERE conn1.status = 'RIGHT' AND conn2.status = 'RIGHT' " +
            "AND (conn1.user_from = ?1 OR conn1.user_to = ?1 )",nativeQuery = true)
    List<User> findMatches(Integer userId);


    @Query(value = "SELECT * FROM users JOIN connections ON user_to = users.id WHERE user_from = ?1",nativeQuery = true)
    List<User> findUsersVotedByMe(Integer userId);
}
