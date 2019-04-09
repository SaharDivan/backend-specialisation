package at.nacs.marco;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/say")
@RequiredArgsConstructor
public class SayEndpoint {

    private final RestTemplate restTemplate;


    @Value("${polo.server.url}")
    private String urlPolo;


    @GetMapping("/{message}")
    public String askForMessage(@PathVariable String message){
         return
                 restTemplate.postForObject(urlPolo,message,String.class);

    }

}
