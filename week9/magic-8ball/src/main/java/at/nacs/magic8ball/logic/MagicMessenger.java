package at.nacs.magic8ball.logic;

import at.nacs.magic8ball.domain.Message;
import at.nacs.magic8ball.configuration.MessageListConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MagicMessenger {

    private final List<Message> messages;
    private Random random = new Random();

    public Message tellFortune(){
        int index = random.nextInt(messages.size());
        return messages.get(index);
    }
}
