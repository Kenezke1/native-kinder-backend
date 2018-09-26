package com.codecool.kinder.contoller;


import com.codecool.kinder.exceptions.NoImageFoundException;
import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.model.Image;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.simple.ImageService;
import com.codecool.kinder.simple.ProfileService;
import com.codecool.kinder.simple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
class ProfileController {


    @Autowired
    private ProfileService profileService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    Profile getProfileByUserId(@RequestParam("id") Integer userId) throws ProfileNotFoundException {
        return profileService.getProfileByUser(userId);
    }


    @GetMapping("/images")
    List<Image> getImagesByProfileId(@RequestParam("profileId") Integer profileId) throws ProfileNotFoundException, NoImageFoundException {
        return imageService.getImagesByProfileId(profileId);
    }
}
