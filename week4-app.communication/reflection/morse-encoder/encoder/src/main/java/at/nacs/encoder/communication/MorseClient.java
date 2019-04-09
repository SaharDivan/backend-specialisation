package at.nacs.encoder.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MorseClient {
    private final RestTemplate restTemplate;

    @Value("S{morse.server.url}")
    private String url;

    public String send(String letter) {
        return restTemplate.postForObject(url, letter, String.class);
    }

}
