package at.nacs.passwordverifier.logic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SafetyMeasureTest {

    @Autowired
    SafetyMeasure safetyMeasure;

    @ParameterizedTest
    @CsvSource({
            "absS3456r,true",
            "sa,false"
    })
    void isSafetyMeasureSatisfied(String password, String verification) {
        Boolean actual = safetyMeasure.isSafetyMeasureSatisfied(password);

        Assertions.assertThat(actual).isEqualTo(Boolean.valueOf(verification));
    }

}