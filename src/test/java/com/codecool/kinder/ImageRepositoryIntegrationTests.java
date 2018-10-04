package com.codecool.kinder;

import com.codecool.kinder.model.Image;
import com.codecool.kinder.model.Profile;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ImageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DataJpaTest
@SpringBootTest(classes = KinderApplication.class)
public class ImageRepositoryIntegrationTests {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void whenFindAllByProfile_thenReturnList(){
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

        Image testImage1 = Image.builder()
                                    .id(1)
                                    .imageUrl("image.com/testUser1")
                                .build();
        Image testImage2 = Image.builder()
                                    .id(2)
                                    .imageUrl("image.com/testUser2")
                                .build();
        testImage1.setProfile(testProfile);
        System.out.println(testProfile);
        entityManager.persist(testImage1);
        entityManager.flush();
        
        testImage2.setProfile(testProfile);
        entityManager.persist(testImage2);
        entityManager.flush();

        List<Image> list = imageRepository.findAllByProfileId(testProfile.getId());
        assertThat(list.get(0).getProfile().getId()).isEqualTo(testProfile.getId());
    }
}
