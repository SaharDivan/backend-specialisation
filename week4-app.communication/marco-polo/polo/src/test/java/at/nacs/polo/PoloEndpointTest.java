package at.nacs.polo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class PoloEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @ParameterizedTest
    @CsvSource({
            "Marco,Polo",
            "Hello,What?",
    })
    void polo(String input, String output) {

        String url = "/polo";
        String response = testRestTemplate.postForObject(url,input,String.class);
        assertThat(response).isEqualTo(output);
    }
}