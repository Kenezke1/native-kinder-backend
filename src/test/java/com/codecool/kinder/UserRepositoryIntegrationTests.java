package com.codecool.kinder;


import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {H2JpaConfig.class,KinderApplication.class},
                      loader = AnnotationConfigContextLoader.class)
@Transactional
@DataJpaTest
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

        Optional<User> found = userRepository.findByEmail(testUser.getEmail());

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

}
