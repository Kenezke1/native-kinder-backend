package com.codecool.kinder.test.repository;

import com.codecool.kinder.KinderApplication;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ProfileRepository;
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
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DataJpaTest
@SpringBootTest(classes = KinderApplication.class)
public class ProfileRepositoryIntegrationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void whenFindById_thenReturnProfile(){
        Profile testProfile = Profile.builder()
                                        .id(1)
                                        .gender("FEMALE")
                                        .birthDate("1943")
                                        .targetGender("MALE")
                                        .ageLimitMin(20)
                                        .ageLimitMax(30)
                                .build();
        entityManager.persist(testProfile);
        entityManager.flush();

        Optional<Profile> found = profileRepository.findById(1);
        assertThat(found.get().getId()).isEqualTo(testProfile.getId());
    }

    @Test
    public void whenFindByUserId_thenReturnProfile(){
        Profile testProfile = Profile.builder()
                                        .id(1)
                                        .gender("FEMALE")
                                        .birthDate("1943")
                                        .targetGender("MALE")
                                        .ageLimitMin(20)
                                        .ageLimitMax(30)
                                    .build();
        User testUser = User.builder()
                                .id(1)
                                .email("testuser@gmail.com")
                                .givenName("User")
                                .familyName("Test")
                                .imageUrl("image.com/testUser")
                            .build();
        entityManager.persist(testUser);
        entityManager.flush();
        testProfile.setUser(testUser);

        entityManager.persist(testProfile);
        entityManager.flush();

        Optional<Profile> found = profileRepository.findByUserId(1);
        assertThat(found.get().getId()).isEqualTo(testProfile.getId());
    }
}
