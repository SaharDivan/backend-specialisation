package at.nacs.basketballtournament.domain;

import lombok.Data;
import java.util.List;

@Data
public class BasketballTeam {
    private String name;
    private List<String> players;
}
