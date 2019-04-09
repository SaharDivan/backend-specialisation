package at.nacs.basketballtournament.logic;

import at.nacs.basketballtournament.domain.BasketballTeam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourtTest {
    Court court = new Court();


    @Test
    void pickContestantTeams() {
        List<BasketballTeam> contestants = court.pickContestantTeams();
        int actual = contestants.size();

        assertEquals(2,actual);

    }

    @Test
    void judgeEachGame() {

        List<BasketballTeam> contestants = Arrays.asList(
                new BasketballTeam(),
                new BasketballTeam());

        BasketballTeam winner = court.judgeEachGame(contestants);
        Optional<BasketballTeam> winner1 = Optional.of(winner);

        assertTrue(winner1.isPresent());

    }
}