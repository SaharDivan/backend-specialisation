package coffee.controller;

import lombok.experimental.UtilityClass;
import coffee.model.BeanCan;

@UtilityClass
public class Ratio {

    Double getRatio(BeanCan beanCan, String color) {
        Integer totalBeans = beanCan.beanQueue.size();
        Integer numberOfColor = Counter.getNumberOfBeans(beanCan, color);
        return getPercentage( numberOfColor,totalBeans);
    }

    public double getPercentage( Integer numberOfColor,Integer totalBeans) {
        return (numberOfColor * 100.00) / totalBeans;
    }
}

