package at.nacs.agent.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HandShakeCodesTest {

    @Autowired
    HandShakeCodes handShakeCodes;

    @Test
   void getHandSign(){
        Map<Integer,String> handShakes = handShakeCodes.getSecretHandShakeCodes();
        assertEquals(5,handShakes.size());
    }

    @ParameterizedTest
    @CsvSource({
            "2,Thumb_Touches_Back",
            "3,Little_Finger_Grab",
            "5,Tickles_Over_Palm",
            "6,Brok_Nock",
            "9,Thousand_Knuckles",
    })

    void getEachHandSign(Integer num, String handShake){
        String actual = handShakeCodes.getSecretHandShakeCodes().get(num);
        assertEquals(handShake,actual);
    }

}