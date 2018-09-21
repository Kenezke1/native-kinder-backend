package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;


public interface UserService {
    User get(String email)throws UserNotFoundException;

    User add(GoogleIdToken.Payload googlePayload);
}
