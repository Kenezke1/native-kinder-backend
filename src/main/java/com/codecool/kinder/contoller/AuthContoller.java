package com.codecool.kinder.contoller;


import com.codecool.kinder.model.User;
import com.codecool.kinder.simple.GoogleService;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthContoller {
    @Autowired
    UserService userService;
    @Autowired
    GoogleService googleService;

    @PostMapping("/google")
    public User googleLogin(@RequestParam(name = "token") String token){
         return googleService.getUserByGoogle(token);
    }

    @GetMapping("/hardcode")
    public User hardCodeLogin(){
        return userService.getByEmail("hegedus.csanad96@gmail.com");
    }

    @GetMapping("")
    public User getUserById(@RequestParam("id") Integer userId){
        return userService.getById(userId);
    }

    @DeleteMapping("")
    public void delete(HttpSession session) {
        session.invalidate();
    }
}
