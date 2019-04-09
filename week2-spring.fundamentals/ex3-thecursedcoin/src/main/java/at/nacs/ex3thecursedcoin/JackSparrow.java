package at.nacs.ex3thecursedcoin;

import at.nacs.ex3thecursedcoin.model.Coin;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JackSparrow {

    private LegendaryCompass legendaryCompass;
    private List<Coin> coins;


    public JackSparrow(LegendaryCompass legendaryCompass) {
        this.legendaryCompass = legendaryCompass;
        this.coins = Arrays.asList(Coin.builder().cursed(true).build());
    }

    public String announceTheFinding() {

        String message = "";
        if (legendaryCompass.findTheCursedCoin(coins)){
            message = "I found the CursedCoin!";
        }
        return message;
    }
}
