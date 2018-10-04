package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Dto.MessageDto;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ConnectionRepository;
import com.codecool.kinder.repository.MessageRepository;
import com.codecool.kinder.simple.MessageService;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<MessageDto> findAllMessageByUserId(Integer userId) {
        List<MessageDto> messageDtos = new ArrayList<>();
        List<Connection> connections = connectionRepository.findMyConnections(userId);
        List<User> users = userService.findMatches(userId);
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < connections.size(); j++) {
                if(connections.get(j).getUserTo().equals(users.get(i).getId()) || connections.get(j).getUserFrom().equals(users.get(i).getId())){
                    messageDtos.add(new MessageDto(users.get(i),messageRepository.findAllByConnectionId(connections.get(j).getId())));

                }
            }
        }
        return messageDtos;

    }
}
