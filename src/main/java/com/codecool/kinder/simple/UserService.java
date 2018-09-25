package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;


public interface UserService {
    User getByEmail(String email);

    User getById(Integer userId);

}
