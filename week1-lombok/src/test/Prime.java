package test;


import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

public class Prime {

    public List<Integer> makePrimes(int max) {
        return IntStream.iterate(1, i -> i+1)
                .filter(e -> isPrime(e))
                .limit(2)
                .boxed()
                .collect(toList());
    }

    private Boolean isPrime(Integer integer) {
        List<Integer> divisors = IntStream.rangeClosed(1, integer)
                .filter(e -> integer % e == 0)
                .boxed()
                .collect(toList());
        return divisors.size() == 2;
    }

}

