package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.UserRepository;
import com.codecool.kinder.simple.GoogleService;
import com.codecool.kinder.simple.UserService;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService,GoogleService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(String email) {
       Optional<User> user = userRepository.findByEmail(email);
       if(!user.isPresent()){
           throw new UserNotFoundException("User with this email not exists!");
       }
       return user.get();
    }

    @Override
    public User getById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("User with this id is not present!");
    }

    @Override
    public User add(GoogleIdToken.Payload googlePayload) {
        return null;
    }

    @Override
    public User addGoogleUser(GoogleIdToken.Payload googlePayload) {
        User user = new User();
        user.setEmail(googlePayload.getEmail());
        user.setFamilyName((String)googlePayload.get("family_name"));
        user.setGivenName((String)googlePayload.get("given_name"));
        user.setImageUrl((String)googlePayload.get("image_url"));
        return userRepository.saveAndFlush(user);
    }

    private GoogleIdToken.Payload getGooglePayload(final String googleToken, final String clientId) {
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(clientId))
                .build();
        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(googleToken);
        } catch (GeneralSecurityException | IOException e) {
            System.out.println(e);
        }
        if (idToken != null) {
            return idToken.getPayload();
        }
        return null;
    }
    @Override
    @Transactional
    public User getUserByGoogle(String token)  {
        Optional<User> user;
        final String CLIENT_ID = "411000030979-hq072pnvtjm7vnr6lipv6bdu0itatklf.apps.googleusercontent.com";
        GoogleIdToken.Payload payload = getGooglePayload(token, CLIENT_ID);
        String email = payload.getEmail();
        user = userRepository.findByEmail(email);
        return user.orElseGet(() -> addGoogleUser(payload));
    }
}
