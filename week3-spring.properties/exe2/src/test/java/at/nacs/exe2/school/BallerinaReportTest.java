package at.nacs.exe2.school;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BallerinaReportTest {

    @Autowired
    BallerinaReport ballerinaReport;

    @Test
    void getBallerinas() {
        List<Ballerina> ballerinas = ballerinaReport.getBallerinas();
        int actual = ballerinas.size();

        assertEquals(3,actual);

    }
}