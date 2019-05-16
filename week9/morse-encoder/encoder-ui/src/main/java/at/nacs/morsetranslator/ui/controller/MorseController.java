package at.nacs.morsetranslator.ui.controller;

import at.nacs.morsetranslator.communication.EncoderClient;
import at.nacs.morsetranslator.ui.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MorseController {

    private final EncoderClient client;

    @ModelAttribute("plaintext")
    Message plaintext() {
        return new Message();
    }

    @GetMapping()
    String page() {
        return "morse-code";
    }

    @PostMapping()
    String post(@Valid Message message, BindingResult result, RedirectAttributesModelMap redirect) {
        if (result.hasErrors()) {
            return page();
        }
        String encoded = client.encode(message.getText());
        redirect.addFlashAttribute("encoded",encoded);
        return "redirect:/";
    }
}