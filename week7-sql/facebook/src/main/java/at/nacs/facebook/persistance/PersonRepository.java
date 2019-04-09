package at.nacs.facebook.persistance;

import at.nacs.facebook.persistance.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByFriendsExists();
    List<Person> findAllByFriendsIsEmpty_Friends();


}
