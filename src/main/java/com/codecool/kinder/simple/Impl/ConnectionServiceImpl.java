package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Status;
import com.codecool.kinder.repository.ConnectionRepository;
import com.codecool.kinder.simple.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    ConnectionRepository connectionRepository;

    @Override
    public List<Connection> findConnections(Integer userId) {
        List<Connection> finalConnections = new ArrayList<>();
        List<Connection> userConnections = connectionRepository.findAllForUser(userId);
        for (Connection connection : userConnections) {
            for (Connection connection1 : connectionRepository.findAllForUser(connection.getUserTo())) {
                if (connection1.getUserTo().equals(connection.getUserFrom()) &&
                    !finalConnections.contains(connection) &&
                    connection1.getUserTo().equals(userId)) {
                    if (connection.getStatus().equals(Status.RIGHT) ||
                        connection.getStatus().equals(Status.SUPER)) {
                    finalConnections.add(connection);
                    }
                }
            }
        }
        return finalConnections;
    }

    @Override
    public List<Connection> findAllMatches(Integer userId) {
        return connectionRepository.findAllMatch(userId);
    }


}
