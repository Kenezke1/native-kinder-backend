package com.codecool.kinder.repository;

import com.codecool.kinder.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByConnectionId(Integer connectionId);
}
