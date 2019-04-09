package at.nacs.ex3thecursedcoin.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

@Value
@Builder
@Component
public class CursedCoin extends Coin {
    private boolean cursed = true;
}
