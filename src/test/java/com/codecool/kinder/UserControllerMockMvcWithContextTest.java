package com.codecool.kinder;

import com.codecool.kinder.contoller.AuthController;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.UserRepository;
import com.codecool.kinder.simple.GoogleService;
import com.codecool.kinder.simple.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AuthController.class ,secure = false)
public class UserControllerMockMvcWithContextTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private GoogleService googleService;

    private JacksonTester<User> jsonUser;

    @Before
    public void setup(){
        JacksonTester.initFields(this,new ObjectMapper());
    }

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {

        given(userService.getById(2)).willReturn(User.builder()
                                        .id(2)
                                        .email("hegedus.csanad96@gmail.com")
                                        .givenName("Csanád")
                                        .familyName("Hegedűs")
                                        .imageUrl("https://media.vanityfair.com/photos/564f575b0e42b20e5429f635/master/w_768,c_limit/chris-hemsworth-bruce-weber-january-2016-holiday-cover-vf-05.jpg")
                                    .build());

        MockHttpServletResponse response = mvc.perform(get("/auth?id=2")
                                .accept(MediaType.APPLICATION_JSON))
                            .andReturn().getResponse();


        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonUser.write(User.builder()
                                    .id(2)
                                    .email("hegedus.csanad96@gmail.com")
                                    .givenName("Csanád")
                                    .familyName("Hegedűs")
                                    .imageUrl("https://media.vanityfair.com/photos/564f575b0e42b20e5429f635/master/w_768,c_limit/chris-hemsworth-bruce-weber-january-2016-holiday-cover-vf-05.jpg")
                                .build()).getJson());
    }

}
