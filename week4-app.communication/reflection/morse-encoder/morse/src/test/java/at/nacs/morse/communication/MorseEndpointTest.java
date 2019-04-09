package at.nacs.morse.communication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MorseEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void transport() {
        String url = "/morse";
        testRestTemplate.postForObject(url,"A",String.class);
    }
}