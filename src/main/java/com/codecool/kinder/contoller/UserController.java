package com.codecool.kinder.contoller;


import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("")
    public void deleteUser(@RequestParam("userId") Integer userId) throws UserNotFoundException{
        userService.deleteById(userId);
    }
}
