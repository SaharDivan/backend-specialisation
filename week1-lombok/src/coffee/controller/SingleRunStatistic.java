package coffee.controller;

import lombok.Builder;
import lombok.extern.java.Log;
import coffee.model.Bean;
import coffee.model.BeanCan;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Log
@Builder
public class SingleRunStatistic {

    public List<Object> runOneRound() {
        BeanGenerator beanGenerator = new BeanGenerator();
        List<Object> info = new ArrayList<>();
        BeanCan beanCan = beanGenerator.generateBeanCan(100);
        Integer size = beanCan.beanQueue.size();

        //Double whiteRatio = cutDigits(Ratio.getRatio(beanCan, "white"));
        // Double blackRatio = cutDigits(Ratio.getRatio(beanCan, "black"));
        //info.add(whiteRatio);
        //info.add(blackRatio);

        info.add(beanCan);
        info.add(size);
        info.add(Counter.getNumberOfBeans(beanCan,"white"));
        info.add(Counter.getNumberOfBeans(beanCan,"black"));

        Bean lastBean = filterBeans(beanCan);
        info.add(lastBean);
        info.add("");

        return info;
    }

    private Bean filterBeans(BeanCan copyCan) {

        return Inspector.pick(copyCan).beanQueue.element();
    }


    public Double cutDigits(double radius) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf( df.format(radius));

    }

}
