package com.codecool.kinder.simple.Impl;

import com.codecool.kinder.exceptions.ProfileNotFound;
import com.codecool.kinder.model.Image;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ImageRepository;
import com.codecool.kinder.repository.ProfileRepository;
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
    private ImageRepository imageRepository;
    @Override
    public Profile getProfileByUser(Integer userId) throws ProfileNotFound {
        Optional<Profile> profile = profileRepository.findByUserId(userId);
        if(!profile.isPresent()){
            throw new ProfileNotFound("Profile not found");
        }
        return profile.get();
    }

    @Override
    public List<Image> getImageByProfileId(Integer profileId) throws ProfileNotFound {
        Optional<List<Image>> images = imageRepository.findAllByProfileId(profileId);
        if(images.isPresent()){
            return images.get();
        }
        throw new ProfileNotFound("Cannot find images with this profile!");
    }
}
