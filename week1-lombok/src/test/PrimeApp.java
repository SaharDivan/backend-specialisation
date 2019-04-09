package test;

import java.util.List;

public class PrimeApp {

    public static void main(String[] args) {

        Prime prime = new Prime();
        List<Integer> primes = prime.makePrimes(2);
        System.out.println(primes);
    }
}
