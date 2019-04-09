package at.nacs.duchman.endpoint;


import at.nacs.duchman.domain.DeadMansChest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DeadMansChestEndPointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void giveTheDeadMansChest() {
        String url = "/deadmanschest";

        DeadMansChest actual = testRestTemplate.getForObject(url, DeadMansChest.class);

        Assertions.assertThat(actual.getItem()).isEqualTo("Blue Diamond");
    }
}