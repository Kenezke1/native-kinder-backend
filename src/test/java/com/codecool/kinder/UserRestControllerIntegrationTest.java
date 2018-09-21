package com.codecool.kinder;


import com.codecool.kinder.model.User;
import com.codecool.kinder.simple.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserService.class)
public class UserRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void givenEmail_whenGetUser_theReturnJsonUser()throws Exception{
        User csanád = new User("hegedus.csanad96@gmail.com","Csanád","Hegedűs","https://starschanges.com/wp-content/uploads/2016/04/blake-lively-celebrity-weight-height-and-age.jpg%27");


    }
}
