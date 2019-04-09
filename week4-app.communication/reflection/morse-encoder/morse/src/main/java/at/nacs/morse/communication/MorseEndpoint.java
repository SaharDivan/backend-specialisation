package at.nacs.morse.communication;

import at.nacs.morse.logic.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MorseEndpoint {
    private final Encryptor encryptor;

    @PostMapping("/morse")
    public String transport(@RequestBody String letter) {
        return encryptor.encryptTheLetter(letter);
    }
}
