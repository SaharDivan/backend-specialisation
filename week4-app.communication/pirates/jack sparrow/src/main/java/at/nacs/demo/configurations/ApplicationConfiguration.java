package at.nacs.demo.configurations;

import at.nacs.demo.domain.DeadMansChest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    DeadMansChest deadMansChest(){
        return new DeadMansChest("Blue Diamond");
    }

}
