package at.nacs.reflectionprimes;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

@Component
public class Primes {

    public List<Integer> makePrimes(int max) {
        return IntStream.iterate(1, i -> i+1)
                .filter(e -> isPrime(e))
                .limit(max)
                .boxed()
                .collect(toList());
    }

     Boolean isPrime(Integer integer) {
        return IntStream.rangeClosed(1, integer)
                .filter(e -> integer % e == 0)
                .count() == 2;
    }

}
