package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ConnectionRepository;
import com.codecool.kinder.repository.ProfileRepository;
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
import java.util.*;


@Service
public class UserServiceImpl implements UserService,GoogleService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public User getByEmail(String email) throws UserNotFoundException {
       Optional<User> user = userRepository.findByEmailAndEnabledTrue(email);
       if(!user.isPresent()){
           throw new UserNotFoundException("User with this email not exists!");
       }
       return user.get();
    }

    @Override
    public User getById(Integer userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findByIdAndEnabledTrue(userId);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("User with this id is not present!");
    }

    @Override
    public void deleteById(Integer userId) throws UserNotFoundException {
        Optional<User> deletable = userRepository.findByIdAndEnabledTrue(userId);
        if(deletable.isPresent()){
            deletable.get().setEnabled(false);
            userRepository.saveAndFlush(deletable.get());
        }
        else{
            throw new UserNotFoundException("User with this id is not present!");
        }
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
            e.printStackTrace();
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
        if(payload != null){
            String email = payload.getEmail();
            user = userRepository.findByEmailAndEnabledTrue(email);
            return user.orElseGet(() -> addGoogleUser(payload));
        }else{
            throw new NullPointerException("Payload is null");
        }

    }

    @Override
    public List<User> findUsersNotMatched(Integer userId) throws ProfileNotFoundException {
        List<User> notMatched = userRepository.findUserNotMatched(userId);
        List<User> result = new ArrayList<>();

        Optional<Profile> myProfile = profileRepository.findByUserId(userId);
        notMatched.removeAll(findMatches(userId));
        for(User user : notMatched){
            Optional<Profile> profile = profileRepository.findByUserId(user.getId());
            if(profile.isPresent() && myProfile.get().getTargetGender().equals(profile.get().getGender())){
                result.add(user);
            }
        }
        result.removeAll(userRepository.findUsersVotedByMe(userId));
        return result;
    }


    @Override
    public List<User> findMatches(Integer userId){
        List<User> matches = userRepository.findMatches(userId);
        Optional<User> myself = userRepository.findByIdAndEnabledTrue(userId);
        matches.remove(myself.get());
        return matches;
    }
}
