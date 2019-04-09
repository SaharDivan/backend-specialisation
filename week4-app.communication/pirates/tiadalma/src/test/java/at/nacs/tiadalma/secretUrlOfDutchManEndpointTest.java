package at.nacs.tiadalma;


import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Log
class secretUrlOfDutchManEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void giveUrl() {

        String url = "/dutchman";
        String actual = testRestTemplate.getForObject(url, String.class);

        log.severe("Dutch Man's URL: "+actual);
        Assertions.assertThat(actual).isNotEmpty();


    }
}