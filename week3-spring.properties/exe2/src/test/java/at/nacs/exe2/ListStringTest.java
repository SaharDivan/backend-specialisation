package at.nacs.exe2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ListStringTest {

    @Autowired
    ListString weekDays;
    @Test
    void getWeekDays() {
        int actual = weekDays.getWeekDays().size();

        assertEquals(7,actual);
    }
}