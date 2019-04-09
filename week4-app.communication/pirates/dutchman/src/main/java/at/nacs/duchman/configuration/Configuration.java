package at.nacs.duchman.configuration;

import at.nacs.duchman.domain.DeadMansChest;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    DeadMansChest deadMansChest(){
        return new DeadMansChest("Blue Diamond");
    }

}
