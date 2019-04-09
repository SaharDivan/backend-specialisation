package at.nacs.duchman.endpoint;

import at.nacs.duchman.domain.DeadMansChest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DeadMansChestEndPoint {

    private final DeadMansChest deadMansChest;

    @GetMapping("/deadmanschest")
    DeadMansChest giveTheDeadMansChest(){
        return deadMansChest;
    }
}
