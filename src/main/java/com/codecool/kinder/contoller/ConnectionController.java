package com.codecool.kinder.contoller;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.simple.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

    @GetMapping("/connections")
    public List<Connection> findConnections(@RequestParam("userId") Integer userId) {
        return connectionService.findConnections(userId);
    }

}
