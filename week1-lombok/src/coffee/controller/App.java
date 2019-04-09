package coffee.controller;


import coffee.model.BeanCan;
import lombok.extern.java.Log;

@Log
public class App {

    static int totalBack = 0;
    static int totalWhite = 0;
    static int totalBean = 0;

    public static void main(String[] args) {

        BeanGenerator generator = new BeanGenerator();

        BeanCan beanCan1 = generator.generateBeanCan(200);
        BeanCan beanCan2 = generator.generateBeanCan(200);

        totalBack =+  Counter.getNumberOfBeans(beanCan1,"black");
        totalWhite =+ Counter.getNumberOfBeans(beanCan1,"white");
        totalBean = totalBack + totalWhite;


        totalBack =  Counter.getNumberOfBeans(beanCan2,"black");
        totalWhite = Counter.getNumberOfBeans(beanCan2,"white");
        totalBean = totalBack + totalWhite;

        double backOverAll = Ratio.getPercentage(totalBack, totalBean);
        double whiteOverAll = Ratio.getPercentage(totalBack, totalBean);

        //System.out.println(" "+beanCan1);
        //System.out.println(" "+beanCan2);
        System.out.println(" "+totalBean);
        System.out.println(" "+totalWhite);
        System.out.println(" "+totalBack);


        BeanCan lastBean = Inspector.pick(beanCan2);
        System.out.println(" "+lastBean);




//        MultipleRun.getStatistic(6);
//
//        long countBlack = MultipleRun.getOverAllStatistic(1000).stream()
//              .map(e -> e.get(4))
//                .filter(e -> e.toString().equals("black"))
//                .count();


    }
}
