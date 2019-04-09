package at.nacs.facebook.logic;

import at.nacs.facebook.persistance.PersonRepository;
import at.nacs.facebook.persistance.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Manager {
    private final PersonRepository repository;

    public List<Person> findAllPersons() {
        return repository.findAll();
    }

    public List<Person> findAllPersonsWithAtLeastOneFriend() {
        return repository.findAllByFriendsExists();
    }

    public List<Person> findAllPersonsWithNoFriend() {
        return repository.findAllByFriendsIsEmpty_Friends();
    }

    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public void beFriend(Long id1, Long id2) {
        Person friend1 = repository.findById(id1).get();
        Person friend2 = repository.findById(id2).get();

        friend1.getFriends().add(friend2);
        friend2.getFriends().add(friend1);

        savePerson(friend1);
        savePerson(friend2);
    }

    public void unFriend(Long id1, Long id2) {

        Person friend1 = repository.findById(id1).get();
        Person friend2 = repository.findById(id2).get();

        friend1.getFriends().remove(friend2);
        friend2.getFriends().remove(friend1);

        savePerson(friend1);
        savePerson(friend2);
    }
}
