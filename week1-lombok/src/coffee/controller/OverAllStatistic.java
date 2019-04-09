package coffee.controller;//package week1_lombok.reflection_friutshop.coffeebean.controller;
//
//import lombok.extern.java.Log;
//import Bean;
//import BeanCan;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//@Log
//public class OverAllStatistic {
//    private SingleRunStatistic staticRecorder = SingleRunStatistic.builder().build();
//
//    public List<Object> runTotalRounds() {
//
//        List<Object> infoSingleRound = staticRecorder.runOneRound();
//        List<Object> infoOverAll = new ArrayList<>();
//
//        BeanCan beanCan = (BeanCan) infoSingleRound.get(0);
//        Bean lastBean = (Bean) infoSingleRound.get(4);
//
//        infoOverAll.add(infoSingleRound.get(1));
//        infoOverAll.add(Counter.getNumberOfBeans(beanCan,"white"));
//        infoOverAll.add(Counter.getNumberOfBeans(beanCan,"black"));
//        infoOverAll.add(lastBean);
//
//        return infoOverAll;
//    }
//
//    public Stack<List<Object>> getOverAllStatistic(Integer round) {
//        Stack<List<Object>> overAllStatistic = new Stack<>();
//
//        for (int repeat = 0; repeat < round; repeat++) {
//            List<Object> info = staticRecorder.runOneRound();
//            overAllStatistic.push(info);
//        }
//        return   overAllStatistic;
//    }
//
//
//}
