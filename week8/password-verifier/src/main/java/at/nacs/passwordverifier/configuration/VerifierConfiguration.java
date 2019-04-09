package at.nacs.passwordverifier.configuration;

import at.nacs.passwordverifier.logic.FeaturesList;
import at.nacs.passwordverifier.logic.PasswordVerifier;
import at.nacs.passwordverifier.logic.SafetyMeasure;
import at.nacs.passwordverifier.ui.VerifierUserInterface;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VerifierConfiguration {

    @Setter
    @Value("${safetymeasure.requiredfeatures}")
    private Integer requiredSafetyFeatures;


    @Bean
    SafetyMeasure safetyMeasure() {
        return new SafetyMeasure(requiredSafetyFeatures, new FeaturesList());
    }

    @Bean
    VerifierUserInterface verifierUserInterface() {
        return new VerifierUserInterface();
    }

    @Bean
    PasswordVerifier passwordVerifier() {
        return new PasswordVerifier(verifierUserInterface(), safetyMeasure());
    }

//    @Bean
//    ApplicationRunner applicationRunner(){
//        return args -> {
//            String passWord = verifierUserInterface().askForPassWord();
//            passwordVerifier().verify(passWord);
//            passwordVerifier().confirmValidityToUser(passWord);
//        };
//    }
}
