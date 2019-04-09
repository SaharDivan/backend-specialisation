//package at.nacs.basketballtournament.logic;
//
//import at.nacs.basketballtournament.domain.BasketballTeam;
//import at.nacs.basketballtournament.domain.TeamLoader;
//import at.nacs.basketballtournament.ui.TournamentAnnouncer;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedList;
//
//
//@Configuration
//public class TournamentConfiguration {
//
//    @Bean
//    public LinkedList<BasketballTeam> loader(){
//        return new TeamLoader().getTeams();
//    }
//
//    @Bean
//    public Tournament tournament(){
//        return new Tournament();
//    }
//
//    @Bean
//    public TournamentAnnouncer announce(){
//        return new TournamentAnnouncer();
//    }
//
//    @Bean
//    public TournamentRunner runTournament(){
//        return new TournamentRunner();
//    }
//
//
//    @Bean
//    public ApplicationRunner application(TournamentRunner tournamentRunner){
//
//        return args -> {
//            tournamentRunner.runTournament(loader());
//        };
//    }
//
//
//}
