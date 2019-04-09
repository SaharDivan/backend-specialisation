package coffee.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import coffee.model.BeanCan;

class BeanGeneratorTest {
     BeanGenerator generator = new BeanGenerator();


    @Test
    void getBeans() {
        Assertions.assertTrue(generator.putBeansInCan(100,"white").size() != 0);
    }

    @Test
    void getBeanCan() {
      BeanCan actual = generator.generateBeanCan(100);
      BeanCan expected = BeanCan.builder().build();
        Assertions.assertEquals(expected,actual);
    }



}