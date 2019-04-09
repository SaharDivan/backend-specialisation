package at.nacs.exe1.school;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("school")
public class BallerinaReport {

    @Getter
    @Setter
    List<Ballerina> ballerinas;
}
