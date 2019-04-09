package at.nacs.basketballtournament.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
@ConfigurationProperties("tournament")
public class TeamLoader {
    @Getter
    @Setter
    public LinkedList<BasketballTeam> teams;
}
