package com.codecool.kinder.contoller;

import com.codecool.kinder.model.Status;
import com.codecool.kinder.model.Dto.StatusDto;
import com.codecool.kinder.simple.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/connections")
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

    @PostMapping("/vote")
    public StatusDto makeAVote(@RequestParam("voterId") Integer voterId, @RequestParam("votedId") Integer votedId , @RequestParam("vote") Status status){
        return connectionService.vote(voterId,votedId,status);
    }

}
