package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Status;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ConnectionRepository;
import com.codecool.kinder.repository.UserRepository;
import com.codecool.kinder.simple.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    ConnectionRepository connectionRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<Connection> findAllMatches(Integer userId) {
        return connectionRepository.findAllMatch(userId);
    }

    @Override
    public Boolean vote(Integer voterId, Integer votedId, Status status) {
        List<User> connections = userRepository.findMatches(voterId);
        Connection connection = new Connection();
        connection.setUserFrom(voterId);
        connection.setUserTo(votedId);
        connection.setStatus(status);
        connectionRepository.saveAndFlush(connection);
        List<User> newConnections = userRepository.findMatches(voterId);
        if(connections.size() != newConnections.size()){
            return true;
        }
        return false;

    }


}
