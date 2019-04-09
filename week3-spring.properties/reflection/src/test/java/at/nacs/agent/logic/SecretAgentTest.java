package at.nacs.agent.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecretAgentTest {

    @Autowired
    SecretAgent secretAgent;


    @ParameterizedTest
    @CsvSource({
            "23,Thumb_Touches_Back - Little_Finger_Grab",
            "195,Thousand_Knuckles - Tickles_Over_Palm",
            "392,Little_Finger_Grab - Thousand_Knuckles - Thumb_Touches_Back",
            "607,Brok_Nock",
            "999,Thousand_Knuckles - Thousand_Knuckles - Thousand_Knuckles",
            "9658230,Thousand_Knuckles - Brok_Nock - Tickles_Over_Palm - Thumb_Touches_Back - Little_Finger_Grab ",
    })

    void getSecretHandShakes(Integer number, String handShakes){
       List<String> actual = secretAgent.giveSecretHandShakes(number);

       List<String> expected = Stream.of(handShakes.split(" - "))
               .flatMap(String::lines)
               .collect(Collectors.toList());

        assertEquals(expected,actual);

    }


    @ParameterizedTest
    @CsvSource({"11",
                "0",
                "180",
                "7777777",
                "-1",
    })
    void emptyLists(Integer number) {
            List<String> actual = secretAgent.giveSecretHandShakes(number);
            assertTrue(actual.isEmpty());
    }
}