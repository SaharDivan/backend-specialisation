package coffee.controller;

import org.junit.jupiter.api.Test;
import coffee.model.Bean;
import coffee.model.BeanCan;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InspectorTest {

    private BeanGenerator generator = new BeanGenerator();




    @Test
    void peek() {
        BeanCan beanCan = generator.generateBeanCan(44);
        Bean actual = Inspector.pick(beanCan).beanQueue.element();

        Bean expected1 =  Bean.builder().color("white").build();
        Bean expected2 =  Bean.builder().color("black").build();
        assertEquals(expected2 ,actual);

    }
    @Test
    void peekcountTest() {
        BeanCan beanCan = generator.generateBeanCan(100);
     Integer actual = Inspector.pick(beanCan).beanQueue.size();

        assertEquals(1 ,actual);

    }

}

