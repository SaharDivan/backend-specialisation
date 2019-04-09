package at.nacs.tweeter.persistancy;

import org.springframework.data.mongodb.repository.MongoRepository;
import at.nacs.tweeter.persistancy.Tweet;
import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {

    List<Tweet> findAllOrderByTimestampDesc();

    List<Tweet> findAllByUserOrderByTimestampDesc(String user);
}
