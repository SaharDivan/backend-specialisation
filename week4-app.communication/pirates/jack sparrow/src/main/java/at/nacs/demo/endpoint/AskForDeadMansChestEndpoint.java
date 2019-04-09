package at.nacs.demo.endpoint;

import at.nacs.demo.domain.DeadMansChest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AskForDeadMansChestEndpoint {
    private final RestTemplate restTemplate;
    private final AskForDutchMansUrlEndpoint dutchMansUrlEndpoint;

    @GetMapping("/deadmanschest/chest/item")
    public String OpenTheMansChest() {
        DeadMansChest theDeadMansChest = getTheDeadMansChest();
        return theDeadMansChest.getItem();
    }

    public DeadMansChest getTheDeadMansChest(){
        String url = dutchMansUrlEndpoint.askTheUrlFromTiaDalma();
        return restTemplate.getForObject(url, DeadMansChest.class);
    }


}
