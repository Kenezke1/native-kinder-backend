package com.codecool.kinder.contoller;


import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/not-matched")
    public List<User> getNotMatchedUsers(@RequestParam("userId") Integer userId) throws ProfileNotFoundException {
        return userService.findUsersNotMatched(userId);
    }

    @GetMapping("matches")
    public List<User> getMatches(@RequestParam("userId") Integer userId){
        return userService.findMatches(userId);

    }

    @DeleteMapping("")
    public void deleteUser(@RequestParam("userId") Integer userId) throws UserNotFoundException{
        userService.deleteById(userId);
    }
}
