package at.nacs.facebook.communication;

import at.nacs.facebook.logic.Manager;
import at.nacs.facebook.persistance.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonEndpoints {
    private final Manager manager;

    @GetMapping
    List<Person> findAllPersons(){
       return manager.findAllPersons();
    }

    @GetMapping("/friends/with")
    List<Person> findAllPersonsWithAtLeastOneFriend(){
        return manager.findAllPersonsWithAtLeastOneFriend();
    }


    @GetMapping("/friends/without")
    List<Person> findAllPersonsWithNoFriend(){
        return manager.findAllPersonsWithNoFriend();
        }

    @PostMapping
    Person saveAPerson(@RequestBody Person person){
      return   manager.savePerson(person);
    }

    @PutMapping("{id1}/friend/{id2}")
    void beFriendTheTwo(Long id1,Long id2 ){
        manager.beFriend(id1,id2);
    }

    @PutMapping("/{id1}/unFriend/{id2}")
    void unFriendTheTwo(Long id1,Long id2 ){
        manager.unFriend(id1,id2);
    }

}
