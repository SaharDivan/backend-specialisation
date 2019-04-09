package at.nacs.passwordverifier.logic;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SafetyMeasure {

    private final Integer requiredSafetyFeatures;
    private final FeaturesList featuresList;

    public Boolean isSafetyMeasureSatisfied(String password) {
        List<Boolean> fulfilledSafetyFeatures = featuresList.checkSafetyFeatures(password);
        return requiredSafetyFeatures <=
                fulfilledSafetyFeatures.stream()
                        .filter(e -> e == true)
                        .count();
    }


}
