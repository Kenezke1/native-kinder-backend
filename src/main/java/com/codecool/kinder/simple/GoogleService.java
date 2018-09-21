package com.codecool.kinder.simple;

import com.codecool.kinder.model.User;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.transaction.Transactional;


public interface GoogleService {

    @Transactional
    User getUserByGoogle(String token);

    User addGoogleUser(GoogleIdToken.Payload googlePayload);

}
