package at.nacs.creditcard.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ListOfCreditCardIssuersTest {

    @Autowired
    ListOfCreditCardIssuers cardIssuer;

    @Test
    void getIssuers() {
        List<CreditCardIssuer> cardIssuerList = cardIssuer.getIssuers();
        int actual = cardIssuerList.size();

        Assertions.assertEquals(7, actual);
    }
}