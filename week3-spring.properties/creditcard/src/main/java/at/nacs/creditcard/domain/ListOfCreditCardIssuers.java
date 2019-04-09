package at.nacs.creditcard.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("credit-card-issuer")
public class ListOfCreditCardIssuers {
    @Setter
    @Getter
    private List<CreditCardIssuer> issuers;
}
