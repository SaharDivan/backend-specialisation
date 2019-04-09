package at.nacs.exe2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Word {

    @Value("${word.word}")
    @Getter
    private String word;
}
