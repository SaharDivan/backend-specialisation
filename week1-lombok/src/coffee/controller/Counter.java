package coffee.controller;

import lombok.experimental.UtilityClass;
import coffee.model.Bean;
import coffee.model.BeanCan;

@UtilityClass
public class Counter {

    public Integer getNumberOfBeans(BeanCan beanCan, String color) {
        Integer reduce = beanCan.beanQueue.stream()
                .map(e -> isColor(e, color))
                .mapToInt(Integer::intValue)
                .sum();
        return reduce;

    }

    private Integer isColor(Bean bean, String color) {
        if (!bean.getColor().equalsIgnoreCase(color)) {
            return 0;
        }
        return 1;
    }

}
