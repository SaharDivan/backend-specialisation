package coffee.controller;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import coffee.model.BeanCan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
@Log
public class MultipleRun {

    private String filePath =
            "/home/sahar/IdeaProjects/backend/src/w1_lombok/reflection_friutshop/view/statistics.txt";

    private SingleRunStatistic singleRunStatistic = SingleRunStatistic.builder().build();

    public List<String> getStatistic(Integer round) {
        int totalBeanNum = 0;
        int totalLastBlack = 0;
        int totalLastWhite = 0;
        int totalWhite = 0;
        int totalBlack = 0;

        List<String> allIndividualRuns = new ArrayList<>();
        List<Object> accumulator = new ArrayList<>();

        Publisher.header();

        for (int repeat = 0; repeat < round; repeat++) {

            List<Object> info = singleRunStatistic.runOneRound();
            WritingFiles.appendString(changeToString(info), filePath);
            //accumulate values:
            totalBeanNum += (int) info.get(1);
            totalWhite += (int) info.get(2);
            totalBlack += (int) info.get(3);
            totalLastWhite += Counter.getNumberOfBeans((BeanCan) info.get(0), "white");
            totalLastBlack += Counter.getNumberOfBeans((BeanCan) info.get(0), "black");
            //accumulator = accumulateValues(info);
            allIndividualRuns.add(changeToString(info));
        }

        accumulator.add("");
        accumulator.add(totalBeanNum);
        accumulator.add(totalWhite*100/totalBeanNum+"%");
        accumulator.add(totalBlack*100/totalBeanNum+"%");
        accumulator.add("white: "+ totalLastWhite);
        accumulator.add("black: "+ totalLastBlack);

        WritingFiles.appendString(changeToString(accumulator), filePath);

        return allIndividualRuns;
    }

    private String changeToString(List<Object> info) {

//        String totalNumber = valueOf(info.get(1));
//        String whiteRatioPrint = valueOf(info.get(2));
//        String blackRatioPrint = valueOf(info.get(3));
//        String lastBeanPrint = valueOf(info.get(4));
//        String last = valueOf(info.get(5));

        return Stream.of(info)
                .map(e-> String.valueOf(e))
                .collect(Collectors.joining());

//        return totalNumber + ", " +
//                whiteRatioPrint + ", " +
//                blackRatioPrint + ", " +
//                lastBeanPrint + ", " +
//                last;
    }

}
