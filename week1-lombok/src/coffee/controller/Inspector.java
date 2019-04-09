package coffee.controller;

import lombok.experimental.UtilityClass;
import coffee.model.Bean;
import coffee.model.BeanCan;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class Inspector {


   public BeanCan pick(BeanCan beanCan) {
        if(beanCan.beanQueue.size() < 2){
            return beanCan;
        }
        inspect(beanCan);
        pick(beanCan);
        return beanCan;
    }

    private void inspect(BeanCan beanCan) {
        Stream.of(beanCan)
                .map(Inspector::peekOnePair)
                .map(Inspector::compare)
                .map(e -> replace(e, beanCan))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private List<Bean> peekOnePair(BeanCan beanCan) {
        return Stream.of(beanCan.beanQueue.poll(), beanCan.beanQueue.poll())
                .collect(Collectors.toList());
    }

    private Boolean compare(List<Bean> pair) {
        return
                pair.get(0).getColor().equals(pair.get(1).getColor());
    }

    private BeanCan replace(Boolean isSameColor, BeanCan beanCan) {
        if (isSameColor) {
            Bean newBlackBean = Bean.builder().color("black").build();
            beanCan.beanQueue.add(newBlackBean);
        } else {
            Bean newWhiteBean = Bean.builder().color("white").build();
            beanCan.beanQueue.add(newWhiteBean);
        }
        return beanCan;
    }
}
