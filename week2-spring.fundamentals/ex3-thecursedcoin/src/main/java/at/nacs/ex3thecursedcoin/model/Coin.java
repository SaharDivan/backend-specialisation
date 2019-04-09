package at.nacs.ex3thecursedcoin.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class Coin {
    private boolean cursed;
}
