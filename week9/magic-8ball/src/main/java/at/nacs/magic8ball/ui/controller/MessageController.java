package at.nacs.magic8ball.ui.controller;


import at.nacs.magic8ball.logic.MagicMessenger;
import at.nacs.magic8ball.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MessageController {

    private final MagicMessenger magicMessenger;

    @ModelAttribute("message")
    Message message() {
        return magicMessenger.tellFortune();
    }


    @GetMapping
    String page() {
        return "message";
    }


}
