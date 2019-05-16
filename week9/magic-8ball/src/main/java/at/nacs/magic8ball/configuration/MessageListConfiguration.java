package at.nacs.magic8ball.configuration;

import at.nacs.magic8ball.domain.Message;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties("fortunes")
@Configuration
public class MessageListConfiguration {

    @Setter
    @Getter
    private List<Message> messages;

    @Bean
    List<Message> messages(){
        return messages;
    }
}
