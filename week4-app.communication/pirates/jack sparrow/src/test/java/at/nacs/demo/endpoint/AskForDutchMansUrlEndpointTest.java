package at.nacs.demo.endpoint;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AskForDutchMansUrlEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void askTheUrlFromTiaDalma() {
        String url = "/deadmanschest/dutchman/url";
        String actual = testRestTemplate.getForObject(url, String.class);

        Assertions.assertThat(actual).isNotEmpty();
    }
}