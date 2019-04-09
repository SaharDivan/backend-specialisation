package at.nacs.passwordverifier.logic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordVerifierTest {

    @Autowired
    PasswordVerifier passwordVerifier;

    @ParameterizedTest
    @CsvSource({
            "pAssWord1,true",
            "PAER,false",
            "sar45$£hh,true",
            "SARALAND100,false"

    })
    void verify(String password, String verification) {
        Boolean actual = passwordVerifier.verify(password);

        Assertions.assertThat(actual).isEqualTo(Boolean.valueOf(verification));
    }


}