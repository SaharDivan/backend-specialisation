package at.nacs.basketballtournament.ui;

import at.nacs.basketballtournament.domain.BasketballTeam;
import at.nacs.basketballtournament.domain.TeamLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TournamentAnnouncer {
  private  TeamLoader teamLoader;

  public void announceTheGame(List<BasketballTeam> contestants, BasketballTeam winner ){

      System.out.println("Welcome to the street basketball tournament!\n");
      System.out.println("These are the teams who signed up:\n");
      System.out.println(teamLoader.getTeams());

      System.out.println(contestants.get(0)+
              "plays vs" +
              contestants.get(1));

      System.out.println("The winner is: " + winner);
  }


}

