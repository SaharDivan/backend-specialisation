package at.nacs.passwordverifier.logic;

import at.nacs.passwordverifier.ui.VerifierUserInterface;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class PasswordVerifier {

    private final VerifierUserInterface verifierUserInterface;
    private final SafetyMeasure safetyMeasure;


    public void confirmValidityToUser(String password) {
        Boolean confirmation = verify(password);
        verifierUserInterface.issuePassWordValidityMessage(confirmation);

    }


    public Boolean verify(String password) {
        return isPasswordValid(password)
                && isPasswordStrongEnough(password);
    }

    private Boolean isPasswordValid(String password) {
        return hasAtLeastOneLowercase(password);
    }

    private Boolean hasAtLeastOneLowercase(String password) {
        String upperCaseComparator = password.toUpperCase();
        return !password.equals(upperCaseComparator);
    }


    private Boolean isPasswordStrongEnough(String password) {
        return safetyMeasure.isSafetyMeasureSatisfied(password);

    }


}
