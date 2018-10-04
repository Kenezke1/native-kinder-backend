package com.codecool.kinder.simple;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Status;
import com.codecool.kinder.model.Dto.StatusDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConnectionService {


    List<Connection> findAllMatches(Integer userId);

    StatusDto vote(Integer voterId, Integer votedId, Status status);


}
