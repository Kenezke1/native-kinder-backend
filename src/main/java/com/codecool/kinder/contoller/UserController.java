package com.codecool.kinder.contoller;


import com.codecool.kinder.exceptions.ConnectionNotFoundException;
import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.Dto.MessageDto;
import com.codecool.kinder.model.Message;
import com.codecool.kinder.model.User;
import com.codecool.kinder.simple.MessageService;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/not-matched")
    public List<User> getNotMatchedUsers(@RequestParam("userId") Integer userId) throws ProfileNotFoundException {
        return userService.findUsersNotMatched(userId);
    }

    @GetMapping("/matches")
    public List<User> getMatches(@RequestParam("userId") Integer userId){
        return userService.findMatches(userId);

    }

    @GetMapping("/messages")
    public List<MessageDto> getMessages(@RequestParam("userId") Integer userId) throws UserNotFoundException {
        return messageService.findAllMessageByUserId(userId);
    }


    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message,@RequestParam("sender") Integer sender,@RequestParam("connection") Integer connectionId) throws ConnectionNotFoundException, UserNotFoundException {
        return this.messageService.sendMessage(message,sender,connectionId);
    }

    @DeleteMapping("")
    public void deleteUser(@RequestParam("userId") Integer userId) throws UserNotFoundException{
        userService.deleteById(userId);
    }
}
