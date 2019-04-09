package at.nacs.exe1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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