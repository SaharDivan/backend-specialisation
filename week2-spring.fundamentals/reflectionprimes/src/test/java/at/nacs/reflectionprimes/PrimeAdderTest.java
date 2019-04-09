package at.nacs.reflectionprimes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PrimeAdderTest {

    @Autowired
    PrimeAdder primeAdder;
    @Autowired
    Primes primes;

    @Test
    void addPrimes() {
        List<Integer> numbers = Arrays.asList(2, 3);
        Integer actual = primeAdder.addPrimes(numbers);
        Integer expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void addPrimesUltimatum() {

        List<Integer> primeNumbers = primes.makePrimes(100);
        Integer actual = primeAdder.addPrimes(primeNumbers);
        Integer expected = 24133;

        assertEquals(expected, actual);
    }
}