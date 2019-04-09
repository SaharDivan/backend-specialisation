package at.nacs.tweeter.logic;

import at.nacs.tweeter.persistancy.Tweet;
import at.nacs.tweeter.persistancy.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetManager {

    private final TweetRepository repository;

    public List<Tweet> findAllTweetsDescending() {
        return repository.findAllOrderByTimestampDesc();
    }

    public List<Tweet> findAllTweetsFromUserDescending(String user) {
        return repository.findAllByUserOrderByTimestampDesc(user);
    }


    public void saveNewTweet(String user, String message) {
        Tweet newTweet = Tweet.builder()
                .user(user)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
        repository.save(newTweet);
    }

    private Optional<Tweet> findATweetByID(String id){
     return  repository.findById(id);
    }


    public void addLikeToTweet(String id){
        Tweet tweet = findATweetByID(id).get();
        int newLike = tweet.getLikes() + 1;
        tweet.setLikes(newLike);
        repository.save(tweet);
    }

    public void addCommentToTweet(String id, String comment){
        Tweet tweet = findATweetByID(id).get();
        tweet.setMessage(comment);
        repository.save(tweet);
    }

}
