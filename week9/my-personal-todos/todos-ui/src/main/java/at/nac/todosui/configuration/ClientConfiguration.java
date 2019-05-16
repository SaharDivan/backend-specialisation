package at.nac.todosui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
