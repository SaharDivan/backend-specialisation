package at.nacs.basketballtournament.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamLoaderTest {

    @Autowired
    TeamLoader teamLoader;

    @Test
    void getTeams() {
        Queue<BasketballTeam> teams = teamLoader.getTeams();
        int actual = teams.size();
        assertEquals(5,actual);
    }
}