package at.nacs.tiadalma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class secretUrlOfDutchManEndpoint {

    @Value("${dutchman.server.url}")
    private String dutchMansUrl;

    @GetMapping("/dutchman")
    String giveUrl(){
        return dutchMansUrl;
    }
}
