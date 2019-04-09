package at.nacs.basketballtournament.logic;
import at.nacs.basketballtournament.domain.BasketballTeam;
import at.nacs.basketballtournament.ui.TournamentAnnouncer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Component
public class Tournament {
    private  TournamentAnnouncer tournamentAnnouncer = new TournamentAnnouncer();
    private Court court = new Court();

    public BasketballTeam runTheGame(){
        List<BasketballTeam> contestants = court.pickContestantTeams();
        BasketballTeam winner = court.judgeEachGame(contestants);
        return winner;
    }



}
