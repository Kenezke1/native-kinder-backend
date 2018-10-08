package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.exceptions.ConnectionNotFoundException;
import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Dto.MessageDto;
import com.codecool.kinder.model.Message;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ConnectionRepository;
import com.codecool.kinder.repository.MessageRepository;
import com.codecool.kinder.repository.UserRepository;
import com.codecool.kinder.simple.MessageService;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
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

    @Override
    public Message sendMessage(Message message, Integer sender, Integer connectionId) throws ConnectionNotFoundException, UserNotFoundException {
        Optional<Connection> connection = this.connectionRepository.findById(connectionId);
        Optional<User> user = userRepository.findById(sender);
        if(!connection.isPresent()){
            throw new ConnectionNotFoundException("Connection with this id is not present!");
        }
        if(!user.isPresent()){
            throw new UserNotFoundException("User with this ID not present!");
        }
        message.setConnection(connection.get());
        message.setSender(user.get());
        message.setTimestamp(new Date().getTime());
        return messageRepository.saveAndFlush(message);
    }


}
