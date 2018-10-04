package com.codecool.kinder;

import com.codecool.kinder.model.Connection;
import com.codecool.kinder.model.Message;
import com.codecool.kinder.model.Status;
import com.codecool.kinder.model.User;
import com.codecool.kinder.repository.MessageRepository;
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

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)

@Transactional
@DataJpaTest
@SpringBootTest(classes = KinderApplication.class)
public class MessageRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void whenFindAllByConnectionId_thenReturnMessageList(){
        Connection testConnection = Connection.builder()
                                            .id(1)
                                            .userFrom(2)
                                            .userTo(3)
                                            .status(Status.RIGHT)
                                        .build();
        entityManager.persist(testConnection);
        entityManager.flush();

        Connection testConnection2 = Connection.builder()
                .id(2)
                .userFrom(2)
                .userTo(3)
                .status(Status.RIGHT)
                .build();
        entityManager.persist(testConnection2);
        entityManager.flush();

        User testUser = User.builder()
                            .id(1)
                            .email("testuser@gmail.com")
                            .givenName("User")
                            .familyName("Test")
                            .imageUrl("image.com/testUser")
                        .build();
        entityManager.persist(testUser);
        entityManager.flush();

        Message testMessage = Message.builder()
                                    .id(1)
                                    .sender(testUser)
                                    .connection(testConnection)
                                    .message("Hello")
                                    .timeStamp(Long.valueOf(1538642555942l))
                                .build();
        Message testMessage2 = Message.builder()
                .id(2)
                .sender(testUser)
                .connection(testConnection)
                .message("Hello")
                .timeStamp(Long.valueOf(1538642555942l))
                .build();
        Message testMessage3 = Message.builder()
                .id(1)
                .sender(testUser)
                .connection(testConnection2)
                .message("Hello")
                .timeStamp(Long.valueOf(1538642555942l))
                .build();
        testMessage.setSender(testUser);
        entityManager.persist(testMessage);
        entityManager.flush();

        testMessage2.setSender(testUser);
        entityManager.persist(testMessage2);
        entityManager.flush();

        testMessage3.setSender(testUser);
        entityManager.persist(testMessage3);
        entityManager.flush();

        List<Message> messages = messageRepository.findAllByConnectionId(testConnection2.getId());
        assertThat(messages.size()).isEqualTo(1);
    }
}
