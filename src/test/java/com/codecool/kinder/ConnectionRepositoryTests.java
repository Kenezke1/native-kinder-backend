package com.codecool.kinder;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Status;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.ConnectionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DataJpaTest
public class ConnectionRepositoryTests {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindAllForUser_thenList(){
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
                                                .userFrom(testUser.getId())
                                                .userTo(3)
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

        List<Connection> connections = connectionRepository.findAllForUser(testUser.getId());
        assertThat(connections.size()).isEqualTo(2);
    }

    @Test
    public void whenFindMyConnections_thenReturnList(){
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

        List<Connection> connections = connectionRepository.findMyConnections(testUser.getId());
        assertThat(connections.size()).isEqualTo(1);
    }

}
