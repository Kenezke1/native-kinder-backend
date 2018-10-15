package com.codecool.kinder.test.repository;


import com.codecool.kinder.KinderApplication;
import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Status;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DataJpaTest
@SpringBootTest(classes = KinderApplication.class)
public class UserRepositoryIntegrationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByEmail_thenReturnUser(){
        User testUser = User.builder()
                            .email("test@gmail.com")
                            .familyName("User")
                            .givenName("Test")
                            .imageUrl("image.com/test-user")
                        .build();
        entityManager.persist(testUser);
        entityManager.flush();

        Optional<User> found = userRepository.findByEmail("test@gmail.com");

        assertThat(found.get().getEmail()).isEqualTo(testUser.getEmail());
    }

    @Test
    public void whenFindById_thenReturnUser(){
        User testUser = User.builder()
                    .id(1)
                    .email("testemail@gmail.com")
                    .givenName("Test")
                    .familyName("User")
                    .imageUrl("image.com/test")
                .build();
        entityManager.persist(testUser);
        entityManager.flush();

        Optional<User> found = userRepository.findById(1);
        assertThat(found.get().getId()).isEqualTo(testUser.getId());
    }

    @Test
    public void whenFindUserNotMatched_thenReturnList(){
        User testUser = User.builder()
                                .id(1)
                                .email("testuser@gmail.com")
                                .givenName("User")
                                .familyName("Test")
                                .imageUrl("image.com/testUser")
                            .build();
        entityManager.persist(testUser);
        entityManager.flush();

        User testUser2 = User.builder()
                                .id(2)
                                .email("testuser2@gmail.com")
                                .givenName("User2")
                                .familyName("Test2")
                                .imageUrl("image.com/testUser2")
                            .build();
        entityManager.persist(testUser2);
        entityManager.flush();

        Connection testConnection = Connection.builder()
                                                .id(1)
                                                .userFrom(testUser.getId())
                                                .userTo(4)
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection);
        entityManager.flush();

        Connection testConnection2 = Connection.builder()
                                                .id(2)
                                                .userFrom(4)
                                                .userTo(testUser.getId())
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection2);
        entityManager.flush();

        Connection testConnection3 = Connection.builder()
                                                .id(3)
                                                .userFrom(5)
                                                .userTo(3)
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection3);
        entityManager.flush();

        List<User> users = userRepository.findUserNotMatched(testUser2.getId());
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void whenFindMatches_thenReturnList(){
        User testUser = User.builder()
                                .id(1)
                                .email("testuser@gmail.com")
                                .givenName("User")
                                .familyName("Test")
                                .imageUrl("image.com/testUser")
                            .build();
        entityManager.persist(testUser);
        entityManager.flush();

        Connection testConnection = Connection.builder()
                                                .id(1)
                                                .userFrom(testUser.getId())
                                                .userTo(4)
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection);
        entityManager.flush();

        Connection testConnection2 = Connection.builder()
                                                .id(2)
                                                .userFrom(4)
                                                .userTo(testUser.getId())
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection2);
        entityManager.flush();

        Connection testConnection3 = Connection.builder()
                                                .id(3)
                                                .userFrom(5)
                                                .userTo(3)
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection3);
        entityManager.flush();

        List<User> users = userRepository.findMatches(testUser.getId());
        assertThat(users.size()).isEqualTo(1);
    }

    //TODO: SOMEHOW THIS IS FAILING, NEEDS TO BE FIXED
    @Test
    public void whenFindUsersVotedByMe_thenReturnList(){
        User testUser = User.builder()
                                .id(1)
                                .email("testuser@gmail.com")
                                .givenName("User")
                                .familyName("Test")
                                .imageUrl("image.com/testUser")
                            .build();
        entityManager.persist(testUser);
        entityManager.flush();

        Connection testConnection = Connection.builder()
                                                .id(1)
                                                .userFrom(testUser.getId())
                                                .userTo(4)
                                                .status(Status.RIGHT)
                                           .build();
        entityManager.persist(testConnection);
        entityManager.flush();

        Connection testConnection2 = Connection.builder()
                                                .id(2)
                                                .userFrom(4)
                                                .userTo(testUser.getId())
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection2);
        entityManager.flush();

        Connection testConnection3 = Connection.builder()
                                                .id(3)
                                                .userFrom(5)
                                                .userTo(3)
                                                .status(Status.RIGHT)
                                            .build();
        entityManager.persist(testConnection3);
        entityManager.flush();

        List<User> users = userRepository.findUsersVotedByMe(testUser.getId());
        assertThat(users.size()).isEqualTo(1);
    }

}
