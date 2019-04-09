package at.nacs.marco;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SayEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void saySomething() {
        String url = "/say";
        String response = testRestTemplate.getForObject(url,String.class);
        assertThat(response).isNotEmpty();
    }

    @Test
    void sentToPolo(){
        String message = "Marco";
        String url = "/polo";
        String noakAtPolo = testRestTemplate.postForObject(url, message, String.class);
        assertThat(noakAtPolo).isEqualTo(message);
    }

}