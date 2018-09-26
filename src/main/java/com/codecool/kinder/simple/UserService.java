package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;


public interface UserService {
    User getByEmail(String email) throws UserNotFoundException;

    User getById(Integer userId) throws UserNotFoundException;

}
