package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.exceptions.NoImageFoundException;
import com.codecool.kinder.exceptions.ProfileAlreadyExistsException;
import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.Image;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ImageRepository;
import com.codecool.kinder.repository.ProfileRepository;
import com.codecool.kinder.repository.UserRepository;
import com.codecool.kinder.simple.ImageService;
import com.codecool.kinder.simple.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService,ImageService{

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Profile getProfileByUser(Integer userId) throws ProfileNotFoundException {
        Optional<Profile> profile = profileRepository.findByUserId(userId);
        if(!profile.isPresent()){
            throw new ProfileNotFoundException("Profile not found");
        }
        return profile.get();
    }

    @Override
    public Profile add(Profile profile, Integer userId) throws UserNotFoundException, ProfileAlreadyExistsException {
        Optional<User> user  = userRepository.findByIdAndEnabledTrue(userId);
        Optional<Profile> existingProfile = profileRepository.findByUserId(userId);
        if(user.isPresent()){
            if(!existingProfile.isPresent()){
                profile.setUser(user.get());
                return profileRepository.saveAndFlush(profile);
            }
            throw new ProfileAlreadyExistsException("Profile already exists on this user!");
        }
        throw new UserNotFoundException("User with this id is not present!");



    }

    @Override
    public List<Image> getImagesByProfileId(Integer profileId) throws ProfileNotFoundException, NoImageFoundException {
        Optional<Profile> profile = profileRepository.findById(profileId);
        if(profile.isPresent()){
            List<Image> images = imageRepository.findAllByProfileIdAndEnabledTrue(profileId);
            if(!images.isEmpty()){
                return images;
            }
            throw new NoImageFoundException("No image added to this profile!");
        }
        throw new ProfileNotFoundException("Profile with this id is not present!");
    }
}
