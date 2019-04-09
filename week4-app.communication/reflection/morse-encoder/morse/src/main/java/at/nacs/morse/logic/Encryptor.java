package at.nacs.morse.logic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("morse")
public class Encryptor {
    @Getter
    @Setter
    private Map<String, String> morseChart;

    public String encryptTheLetter(String letter) {

        return morseChart.get(letter.toUpperCase());
    }

}
