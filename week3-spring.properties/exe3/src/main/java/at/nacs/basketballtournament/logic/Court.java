package at.nacs.basketballtournament.logic;

import at.nacs.basketballtournament.domain.BasketballTeam;
import at.nacs.basketballtournament.domain.TeamLoader;
import at.nacs.basketballtournament.ui.TournamentAnnouncer;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.*;


@Log
@Component
public class Court {

    private Random random = new Random();
    private  TeamLoader teamLoader;
    private  TournamentAnnouncer tournamentAnnouncer;

//    public Court() {
//        this.teamLoader = new TeamLoader();
//        this.tournamentAnnouncer = new TournamentAnnouncer();
//    }

    List<BasketballTeam> pickContestantTeams() {
         LinkedList<BasketballTeam> teams = teamLoader.getTeams();
         log.severe("lala| " + teamLoader.getTeams());
      return Arrays.asList(teams.peek(),teams.peek());
    }


    public  BasketballTeam judgeEachGame(List<BasketballTeam> contestants) {
        BasketballTeam winner = contestants.get(random.nextInt(2));
        tournamentAnnouncer.announceTheGame(contestants,winner);
        return winner;
    }
}
