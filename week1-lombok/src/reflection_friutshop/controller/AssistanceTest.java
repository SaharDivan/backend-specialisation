package week1_lombok.reflection_friutshop.controller;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import week1_lombok.reflection_friutshop.model.Fruit;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Log
class AssistanceTest {

    @Test
    void translate1() {
        List<String> list = Arrays.asList("Apple","orange","watermelon");
        int actual = Assistance.translate(list).size();
        assertTrue(actual == 3);
    }

    @Test
    void translate2() {
        List<String> list = Arrays.asList();
        int actual = Assistance.translate(list).size();
        assertTrue(actual == 0);
    }

    //A meaningless test just for sake of practice!
    @ParameterizedTest
    @ValueSource (strings = { "orange","watermelon","apple","banana"})
    void translate3(String fruit) {
        List<String> listOfStrings = Arrays.asList(fruit);
        List<Fruit> listOfFruits = Assistance.translate(listOfStrings) ;
        Fruit actual= listOfFruits.get(0);

        assertEquals(Fruit.builder().name(fruit).build(), actual);
    }
}