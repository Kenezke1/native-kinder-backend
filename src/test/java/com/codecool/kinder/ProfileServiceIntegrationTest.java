package com.codecool.kinder;

import com.codecool.kinder.exceptions.ProfileNotFound;
import com.codecool.kinder.model.Gender;
import com.codecool.kinder.model.Image;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.repository.ProfileRepository;
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

    @Autowired
    private ProfileService profileService;

    @Before
    public void setUp(){
        Optional<Profile> profile = Optional.of(new Profile(2, Gender.MALE,21,Gender.FEMALE,18,30));
        profile.get().getImages().add(new Image(2,"image_url.com/url/csanad"));

        Mockito.when(profileRepository.findByUserId(2)).thenReturn(profile);
    }

    @Test
    public void whenValidUserId_theProfileShouldBeFound() throws ProfileNotFound {
        Integer validUserId = 2;

        Profile correctProfile = new Profile(2, Gender.MALE,21,Gender.FEMALE,18,30);
        correctProfile.getImages().add(new Image(2,"image_url.com/url/csanad"));

        Profile found = profileService.getProfileByUser(validUserId);

        assertThat(found.getId()).isEqualTo(correctProfile.getId());
    }

    @Test(expected = ProfileNotFound.class)
    public void whenInvalidId_thenUserNotFoundExceptionShouldBeFound() throws ProfileNotFound {
        Integer invalidUserId = 0;

        profileService.getProfileByUser(invalidUserId);
    }
}
