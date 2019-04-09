package at.nacs.exe1.building;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuildingTest {

    @Autowired
    Building building;


    @Test
    void getSaunaSeat() {
        int actual = building.getSauna().getSeats();

        assertEquals(5,actual);

    }

    @Test
    void getSaunaTemperature() {
        double actual = building.getSauna().getTemperature();

        assertEquals(90.0,actual);

    }
}