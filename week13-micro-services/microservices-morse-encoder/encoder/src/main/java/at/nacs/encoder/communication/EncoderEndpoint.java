package at.nacs.encoder.communication;


import at.nacs.encoder.logic.TextEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EncoderEndpoint {
    private final TextEncoder encoder;

    @PostMapping("/encode")
    String getMessage(@RequestBody String plainText) {
        return encoder.encodeText(plainText);
    }


}
