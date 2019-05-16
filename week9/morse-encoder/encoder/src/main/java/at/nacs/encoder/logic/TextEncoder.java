package at.nacs.encoder.logic;

import at.nacs.encoder.communication.MorseClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TextEncoder {

    private final MorseClient morseClient;

    public String encodeText(String plaintext) {
        return Stream.of(plaintext.split(""))
                .flatMap(Stream::of)
                .filter(e -> !e.isEmpty())
                .map(morseClient::send)
                .collect(Collectors.joining());
    }

}

