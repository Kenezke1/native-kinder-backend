package com.codecool.kinder.simple;

import java.util.List;

import com.codecool.kinder.exceptions.ConnectionNotFoundException;
import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.Dto.MessageDto;
import com.codecool.kinder.model.Message;


public interface MessageService {
    List<MessageDto> findAllMessageByUserId(Integer userId);


    Message sendMessage(Message message, Integer sender, Integer connectionId) throws ConnectionNotFoundException, UserNotFoundException;
}
