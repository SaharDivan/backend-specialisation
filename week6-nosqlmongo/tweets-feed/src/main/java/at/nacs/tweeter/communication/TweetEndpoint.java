package at.nacs.tweeter.communication;

import at.nacs.tweeter.logic.TweetManager;
import at.nacs.tweeter.persistancy.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetEndpoint {

    private final TweetManager manager;

    @GetMapping
    List<Tweet> showAllTweetsDescending() {
        return manager.findAllTweetsDescending();
    }

    @GetMapping("/user/{user}")
    List<Tweet> showAllTweetsFromUserDescending(@PathVariable String user) {
        return manager.findAllTweetsFromUserDescending(user);
    }


    @PostMapping
    void postNewTweet(@RequestBody String user, String message) {
        manager.saveNewTweet(user, message);
    }


    @PutMapping("/{id}/likes ")
    void putALikeOnATweet(@PathVariable String id) {
        manager.addLikeToTweet(id);

    }

    @PutMapping("/{id}/comments")
    void putACommentOnATweet(@PathVariable String id, String comment) {
        manager.addCommentToTweet(id, comment);

    }


}
