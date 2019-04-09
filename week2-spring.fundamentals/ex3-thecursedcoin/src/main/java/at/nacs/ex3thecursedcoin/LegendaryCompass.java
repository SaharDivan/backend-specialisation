package at.nacs.ex3thecursedcoin;

import at.nacs.ex3thecursedcoin.model.Coin;
import at.nacs.ex3thecursedcoin.model.CursedCoin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LegendaryCompass {

    public Boolean findTheCursedCoin(List<Coin> coins){
        List<Coin> cursedCoin = coins.stream()
                .filter(e -> e.isCursed())
                .collect(Collectors.toList());
        return !cursedCoin.isEmpty();
    }

}
