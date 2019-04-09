package at.nacs.marathonserver.persistance;

import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class RunnerRepositoryTest {


    @Autowired
    RunnerRepository repository;

    @Test
    void findAll() {
        repository.add(new Runner("Mike", Duration.parse("PT1H10M")));
        repository.add(new Runner("Monica", Duration.parse("PT0H58M")));
        List<Runner> runnerList = repository.findAll();
        Assertions.assertThat(runnerList).isNotEmpty();
    }

    @ParameterizedTest
    @CsvSource({"Mike,PT1H10M"})
    void add(String name, String duration) {
        Runner runner = new Runner(name, Duration.parse(duration));
        repository.add(runner);
        Assertions.assertThat(repository.getRunners()).isNotEmpty();

    }

    @Test
    void findFastest() {
        repository.add(new Runner("Mike", Duration.parse("PT1H10M")));
        repository.add(new Runner("Monica", Duration.parse("PT0H58M")));
        Optional<Runner> actual = repository.findFastest();

        Assertions.assertThat(actual.get().getName()).isEqualTo("Monica");
    }
}