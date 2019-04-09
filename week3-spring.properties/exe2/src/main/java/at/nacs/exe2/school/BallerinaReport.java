package at.nacs.exe2.school;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("school")
@Getter
@Setter
public class BallerinaReport {
    private List<Ballerina> ballerinas;
}
