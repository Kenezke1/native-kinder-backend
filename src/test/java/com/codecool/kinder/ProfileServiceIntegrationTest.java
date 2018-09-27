package com.codecool.kinder;

import com.codecool.kinder.exceptions.NoImageFoundException;
import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.model.Gender;
import com.codecool.kinder.model.Image;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.repository.ImageRepository;
import com.codecool.kinder.repository.ProfileRepository;
import com.codecool.kinder.repository.UserRepository;
import com.codecool.kinder.simple.ImageService;
import com.codecool.kinder.simple.Impl.ProfileServiceImpl;
import com.codecool.kinder.simple.ProfileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class ProfileServiceIntegrationTest {

    @TestConfiguration
    static class ProfileServiceImplTextContextConfiguration{

        @Bean
        public ProfileService profileService() {
            return new ProfileServiceImpl();
        }
    }

    @MockBean
    private ProfileRepository profileRepository;

    @MockBean
    private ImageRepository imageRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ImageService imageService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp(){
        Optional<Profile> profile = Optional.of(new Profile(2, Gender.MALE,"1998.07.23",Gender.FEMALE,18,30));
        profile.get().getImages().add(new Image(2,"image_url.com/url/csanad"));

        Mockito.when(profileRepository.findByUserId(2)).thenReturn(profile);
        Mockito.when(profileRepository.findById(2)).thenReturn(profile);

        List<Image> images = new ArrayList<Image>();
        images.add(new Image(2,"image_url.com/url/csanad"));
        Mockito.when(imageRepository.findAllByProfileIdAndEnabledTrue(2)).thenReturn(images);


        Optional<Profile> noImageProfile = Optional.of(new Profile(1,Gender.MALE,"1996.01.20",Gender.FEMALE,30,40));
        Mockito.when(profileRepository.findById(1)).thenReturn(noImageProfile);
    }

    @Test
    public void whenValidUserId_theProfileShouldBeFound() throws Throwable {
        Integer validUserId = 2;

        Profile correctProfile = new Profile(2, Gender.MALE,"1998.07.23",Gender.FEMALE,18,30);
        correctProfile.getImages().add(new Image(2,"image_url.com/url/csanad"));

        Profile found = profileService.getProfileByUser(validUserId);

        assertThat(found.getId()).isEqualTo(correctProfile.getId());
    }

    @Test(expected = ProfileNotFoundException.class)
    public void whenInvalidId_thenProfileNotFoundExceptionShouldBeFound() throws Throwable {
        Integer invalidUserId = 0;
        profileService.getProfileByUser(invalidUserId);
    }

    @Test
    public void whenValidProfileId_thenImageListShouldBeFound()throws Throwable{
        Integer validProfileId = 2;

        List<Image> correctImages = new ArrayList<>();
        correctImages.add(new Image(2,"image_url.com/url/csanad"));

        List<Image> found = imageService.getImagesByProfileId(validProfileId);
        assertThat(found.get(0).getImageUrl()).isEqualTo(correctImages.get(0).getImageUrl());

    }

    @Test(expected = ProfileNotFoundException.class)
    public void whenInvalidProfileId_thenProfileNotFoundExceptionShouldBeFound() throws Exception {
        Integer invalidProfileId = 0;
        imageService.getImagesByProfileId(invalidProfileId);
    }

    @Test(expected = NoImageFoundException.class)
    public void whenInvalidProfileId_thenNoImageFoundExceptionShouldBeFound() throws Exception{
        Integer validProfileId = 1;
        imageService.getImagesByProfileId(validProfileId);
    }


}
