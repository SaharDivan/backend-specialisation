package at.nacs.encoder.communication;

import at.nacs.encoder.logic.MorseClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MorseEndpoint {
    private final MorseClient morseClient;

    public String send(String letter) {
        return morseClient.sendLetter(letter);
    }

}
