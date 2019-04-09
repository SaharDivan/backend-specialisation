package at.nacs.exe1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WordTest {

    @Autowired
    Word word;

    @Test
    void getWord() {
        String actual = this.word.getWord();
        assertEquals("fantastic",actual);

    }
}