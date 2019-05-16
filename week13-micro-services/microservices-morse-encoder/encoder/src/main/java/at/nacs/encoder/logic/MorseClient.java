package at.nacs.encoder.logic;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("morse")
public interface MorseClient {

    @PostMapping("/morse")
    String sendLetter(String Letter);
}
