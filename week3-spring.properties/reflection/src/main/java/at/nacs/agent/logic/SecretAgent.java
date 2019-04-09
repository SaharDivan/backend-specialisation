package at.nacs.agent.logic;

import at.nacs.agent.domain.HandShakeCodes;
import at.nacs.agent.ui.Displayer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Component
@RequiredArgsConstructor
public class SecretAgent {
    private final HandShakeCodes handShakeCodes;
    private final Displayer displayer;


    public List<String> giveSecretHandShakes(Integer price){
         Map<Integer, String> keyMap = handShakeCodes.getSecretHandShakeCodes();

         if (isNotMeaningfulPrice(price)){
             return new ArrayList<>();
         }

       List<String> listOfHandShake =
        Arrays.asList(String.valueOf(price).split("(?<=.)")).stream()
               .map(Integer::valueOf)
               .filter(e -> keyMap.containsKey(e))
               .map(keyMap::get)
               .collect(toList());

       displayer.display(price,listOfHandShake);
       return listOfHandShake;
   }

    private boolean isNotMeaningfulPrice(Integer price) {
        return price < 0 || String.valueOf(price).isEmpty();
    }

}
