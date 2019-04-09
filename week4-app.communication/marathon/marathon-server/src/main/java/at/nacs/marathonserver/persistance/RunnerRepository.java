package at.nacs.marathonserver.persistance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RunnerRepository {

    private Set<Runner> runners = new HashSet<>();

    public List<Runner> findAll(){
         return new ArrayList<>(runners);
    }

    public void add(Runner runner){
        runners.add(runner);
    }

    public Optional<Runner> findFastest(){
       return   runners.stream()
                 .min(Comparator.comparing(Runner::getTime));
    }


}
