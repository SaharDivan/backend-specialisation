package at.nacs.facebook.persistance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
@Entity
@EqualsAndHashCode(exclude = "friends")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Person> friends = new ArrayList<>();


    @Override
    public String toString() {
        return
                " friends= {" +
                        friends.stream()
                        .map(Person::getName)
                        .collect(toList())
                        +
                '}';
    }

}
