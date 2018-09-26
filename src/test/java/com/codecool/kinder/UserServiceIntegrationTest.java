package com.codecool.kinder;


import com.codecool.kinder.exceptions.UserNotFoundException;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.UserRepository;
import com.codecool.kinder.simple.Impl.UserServiceImpl;
import com.codecool.kinder.simple.UserService;
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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceIntegrationTest {

    @TestConfiguration
    static class UserServiceImplTextContextConfiguration{

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp(){
        Optional<User> user = Optional.of(new User(2,"hegedus.csanad96@gmail.com", "Csanád", "Hegedűs", "https://starschanges.com/wp-content/uploads/2016/04/blake-lively-celebrity-weight-height-and-age.jpg%27"));
        Mockito.when(userRepository.findByEmailAndEnabledTrue(user.get().getEmail())).thenReturn(user);
        Mockito.when(userRepository.findByIdAndEnabledTrue(user.get().getId())).thenReturn(user);
    }
    @Test
    public void whenValidEmail_thenUserShouldBeFound() throws Exception {
        String validEmail = "hegedus.csanad96@gmail.com";

        User found = userService.getByEmail(validEmail);

        assertThat(found.getEmail()).isEqualTo(validEmail);
    }

    @Test(expected = UserNotFoundException.class)
    public void whenInvalidEmail_thenUserNotFoundExceptionShouldBeFound() throws Exception {
        String invalidEmail = "imNotValid!";
        userService.getByEmail(invalidEmail);
    }

    @Test
    public void whenValidId_thenUserShouldBeFound() throws Exception {
        Integer validUserId = 2;

        User found  = userService.getById(validUserId);

        assertThat(found.getId()).isEqualTo(validUserId);
    }

    @Test(expected = UserNotFoundException.class)
    public void whenInvalidId_thenUserNotFoundExceptionShouldBeFound() throws Exception {
        Integer invalidUserId = 0;
        userService.getById(invalidUserId);
    }
}
