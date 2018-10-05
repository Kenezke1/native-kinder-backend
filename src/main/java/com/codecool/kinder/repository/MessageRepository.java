package com.codecool.kinder.repository;

import com.codecool.kinder.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "SELECT id,connection_id, sender, message,time_stamp FROM messages WHERE connection_id = ?1 ORDER BY time_stamp ASC", nativeQuery = true)
    List<Message> findAllByConnectionId(Integer connectionId);
}
