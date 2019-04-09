package at.nacs.morse.logic;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@Log
@SpringBootTest(webEnvironment = NONE)
class EncryptorTest {
    @Autowired
    Encryptor encryptor;

    @ParameterizedTest
    @CsvSource({
            "A,. _",
            "a,. _",
            "B,_ . . .",
            "0,_ _ _ _ _"
    })
    void encryptTheLetter(String planText, String encrypted) {
        String actual = encryptor.encryptTheLetter(planText);

        assertThat(actual).isEqualTo(encrypted);
    }

    @Test
    void getMorseChart() {
        Map<String, String> actual = encryptor.getMorseChart();
        log.severe("chart: "+ actual.entrySet());

        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual).containsKeys("A","B","1","0");
    }
}