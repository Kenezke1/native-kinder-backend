package com.codecool.kinder.simple;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Status;

import java.util.List;

public interface ConnectionService {


    List<Connection> findAllMatches(Integer userId);

    Boolean vote(Integer voterId, Integer votedId, Status status);
}
