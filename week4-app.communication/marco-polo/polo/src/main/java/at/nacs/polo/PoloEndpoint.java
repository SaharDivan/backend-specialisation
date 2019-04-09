package at.nacs.polo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@RestController
@RequestMapping("/polo")
@RequiredArgsConstructor
public class PoloEndpoint {

    @PostMapping()
    String polo(@RequestBody String message){
        if (message.equalsIgnoreCase("Marco")) {
            return "Polo";
        }
        return "What?";
    }

}
