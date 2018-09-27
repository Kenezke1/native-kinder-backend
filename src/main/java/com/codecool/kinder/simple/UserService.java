package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;

import java.util.List;


public interface UserService {
    User getByEmail(String email) throws UserNotFoundException;

    User getById(Integer userId) throws UserNotFoundException;

    void deleteById(Integer userId) throws UserNotFoundException;

    List<User> findUsersNotMatched(Integer userId) throws ProfileNotFoundException;

    List<User> findMatches(Integer userId);
}
