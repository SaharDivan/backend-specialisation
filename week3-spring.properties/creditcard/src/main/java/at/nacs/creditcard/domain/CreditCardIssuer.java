package at.nacs.creditcard.domain;

import lombok.Data;

import java.util.Set;

@Data
public class CreditCardIssuer {

    private String name;
    private Set<String> startWith;
    private Set<String> notStartWith;
    private Set<Integer> length;
}

