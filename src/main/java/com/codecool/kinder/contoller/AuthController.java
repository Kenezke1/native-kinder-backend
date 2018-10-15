package com.codecool.kinder.contoller;


import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;
import com.codecool.kinder.simple.GoogleService;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoogleService googleService;

    @PostMapping("/google")
    public User googleLogin(@RequestParam(name = "token") String token){
         return googleService.getUserByGoogle(token);
    }

    @GetMapping("/hardcode")
    public User hardCodeLogin() throws UserNotFoundException {
        return userService.getByEmail("hegedus.csanad96@gmail.com");
    }

    @GetMapping("")
    public User getUserById(@RequestParam("id") Integer userId) throws UserNotFoundException {
        return userService.getById(userId);
    }

    @DeleteMapping("")
    public void delete(HttpSession session) {
        session.invalidate();
    }
}