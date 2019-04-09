package at.nacs.reflectionprimes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PrimesTest {

    @Autowired
    Primes primes;

    @Test
    void makePrimes(){
        List<Integer> actual = primes.makePrimes(2);
        List<Integer> expected = Arrays.asList(2,3);

        assertEquals(expected,actual);

    }

    @ParameterizedTest
    @CsvSource({
         "false, 1"
    })
    void testIsPrime(boolean expected, int number){
        boolean actual = primes.isPrime(number);
        assertEquals(expected, actual);
    }

}