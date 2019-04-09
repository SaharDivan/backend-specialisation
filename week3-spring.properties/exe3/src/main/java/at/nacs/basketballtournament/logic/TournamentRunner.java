package at.nacs.basketballtournament.logic;

import at.nacs.basketballtournament.domain.BasketballTeam;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
public class TournamentRunner {

    private Tournament tournament = new Tournament();

    BasketballTeam runTournament(Queue<BasketballTeam> teams) {
            if (teams.size() > 1) {
                tournament.runTheGame();
                runTournament(teams);
            }

            return teams.element();
        }



}
