package at.nacs.exe1.school;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BallerinaReportTest {

    @Autowired
    BallerinaReport ballerinaReport;

    @Test
    void ballerinaReport(){
        List<Ballerina> ballerinas = ballerinaReport.ballerinas;
        int actual = ballerinas.size();

        Assertions.assertEquals(3,actual);
    }

}