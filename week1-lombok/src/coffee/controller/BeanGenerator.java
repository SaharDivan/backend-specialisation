package coffee.controller;

import lombok.experimental.UtilityClass;
import coffee.model.Bean;
import coffee.model.BeanCan;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BeanGenerator {
    private Random random = new Random();

    public BeanCan generateBeanCan(Integer max) {
        List<Bean> beans = getBeans(max);
        Queue<Bean> shuffledBeans = putBeansInQueue(beans);

        return BeanCan.builder().beanQueue(shuffledBeans).build();
    }

    private List<Bean> getBeans(Integer max) {
        List<Bean> beans = new ArrayList<>();
        beans.addAll(putBeansInCan(max, "black"));
        beans.addAll(putBeansInCan(max, "white"));
        return beans;
    }

    public List<Bean> putBeansInCan(Integer max, String color) {
        return IntStream.generate(() -> 0)
                .takeWhile(e -> e < random.nextInt(max))
                .mapToObj(e -> makeBean(color))
                .collect(Collectors.toList());
    }

    private Bean makeBean(String color) {
        return Bean.builder().color(color).build();

    }

    private static Queue<Bean> putBeansInQueue(List<Bean> beans) {
        Queue<Bean> shuffleBeans = new LinkedList<>();
        Collections.shuffle(beans);
        shuffleBeans.addAll(beans);
        return shuffleBeans;
    }
}
