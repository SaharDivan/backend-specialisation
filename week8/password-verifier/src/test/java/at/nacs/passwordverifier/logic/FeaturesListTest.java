package at.nacs.passwordverifier.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FeaturesListTest {

    @Autowired
    FeaturesList featuresList;

    @ParameterizedTest
    @CsvSource({
            "Assap789",
            "rt",
            "7809887654",
    })
    void checkSafetyFeatures(String password) {
        List<Boolean> safetyFeatures = featuresList.checkSafetyFeatures(password);

        assertThat(safetyFeatures.size()).isEqualTo(4);

    }

    @Test
    void checkSafetyFeaturesForEmpty() {
        List<Boolean> safetyFeatures = featuresList.checkSafetyFeatures(" ");

        assertThat(safetyFeatures.size()).isEqualTo(4);

    }

    @Test
    void checkSafetyFeaturesFirNull() {
        List<Boolean> safetyFeatures = featuresList.checkSafetyFeatures("");

        assertThat(safetyFeatures.size()).isEqualTo(4);

    }


    @ParameterizedTest
    @CsvSource({
            "Assap789,true",
            "ss,false",
            "780,false",
            "AS$,true",
    })
    void hasAtLeastOneUppercase(String password, String verification) {
        Boolean actual = featuresList.hasAtLeastOneUppercase(password);

        assertThat(actual).isEqualTo(Boolean.valueOf(verification));
    }

    @ParameterizedTest
    @CsvSource({
            "As786,true",
            "rt,false",
            "70,true",
    })
    void hasAtLeastOneDigit(String password, String verification) {
        Boolean actual = featuresList.hasAtLeastOneDigit(password);

        assertThat(actual).isEqualTo(Boolean.valueOf(verification));

    }
}