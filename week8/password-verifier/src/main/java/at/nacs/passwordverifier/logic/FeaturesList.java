package at.nacs.passwordverifier.logic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FeaturesList {


    public List<Boolean> checkSafetyFeatures(String password) {
        return Arrays.asList(
                isNotNull(password),
                isLengthLargeEnough(password),
                hasAtLeastOneUppercase(password),
                hasAtLeastOneDigit(password)
        );
    }

    Boolean isNotNull(String password) {
        return !password.isBlank();
    }

    Boolean isLengthLargeEnough(String password) {
        return password.length() > 8;
    }

    Boolean hasAtLeastOneUppercase(String password) {
        String lowerCaseComparator = password.toLowerCase();
        return !password.equals(lowerCaseComparator);
    }

    Boolean hasAtLeastOneDigit(String password) {
        return password.matches("(.)*(\\d)(.)*");
    }

}
