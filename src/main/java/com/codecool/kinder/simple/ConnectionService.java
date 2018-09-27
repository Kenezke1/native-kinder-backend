package com.codecool.kinder.simple;

import com.codecool.kinder.model.Connection;

import java.util.List;

public interface ConnectionService {

    List<Connection> findConnections(Integer userId);
}
