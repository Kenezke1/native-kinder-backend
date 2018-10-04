package com.codecool.kinder.simple;

import java.util.List;

import com.codecool.kinder.model.Dto.MessageDto;


public interface MessageService {
    List<MessageDto> findAllMessageByUserId(Integer userId);


}
