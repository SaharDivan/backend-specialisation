package at.nacs.marathonserver.communication;

import at.nacs.marathonserver.persistance.Runner;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.Duration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RunnerEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    RunnerEndpoint runnerEndpoint;


    @Test
    void getAll() {
        String url = "/runners/all";
        Runner response = testRestTemplate.getForObject(url, Runner.class);
        Assertions.assertThat(response).isEqualTo("");


    }


    @ParameterizedTest
    @CsvSource({"Mike,PT1H10M"})
    void add(String name, String duration) {
        Runner runner = new Runner(name, Duration.parse(duration));
        String url = "/runners";
        String response = testRestTemplate.postForObject(url, runner, String.class);

        Assertions.assertThat(response).isEqualTo("Add to the runner list: Runner(name=Mike, time=PT1H10M)");
    }
}