package at.nacs.demo.endpoint;

import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Log
class AskForDeadMansChestEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void openTheMansChest() {
        String url = "/deadmanschest/chest";
        String actual = testRestTemplate.getForObject(url, String.class);

        Assertions.assertThat(actual).isNotEmpty();
        log.severe("The Item in the dead man's chest is: " + actual);

    }
}