package com.codecool.kinder.simple;

import com.codecool.kinder.model.User;

import javax.transaction.Transactional;


public interface GoogleService {

    @Transactional
    User getUserByGoogle(String token);
}
