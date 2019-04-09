package at.nacs.exe1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberTest {

    @Autowired
    Number number;

    @Test
    void getNum() {
        Integer actual = number.getNum();

        assertEquals(Integer.valueOf(369),actual);

    }
}