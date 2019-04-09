package at.nacs.reflectionprimes;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrimeAdder {
    public Integer addPrimes(List<Integer> primes) {
        return primes.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

