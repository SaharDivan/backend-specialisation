package at.nacs.demo.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/deadmanschest/dutchman")
@RequiredArgsConstructor
public class AskForDutchMansUrlEndpoint {

    private final RestTemplate restTemplate;

    @Value("${tiaDalma.server.url}")
    String tiaDalmaUrl;

    @GetMapping("/url")
  public String askTheUrlFromTiaDalma(){
        return   restTemplate.getForObject(tiaDalmaUrl,String.class);
    }
}
