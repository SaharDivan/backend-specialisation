package at.nacs.exe2.building;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("building")
@Data
public class Building {

    private Sauna sauna;

}
