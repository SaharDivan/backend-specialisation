package coffee.controller;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class Publisher {

    private String filePath =
            "/home/sahar/IdeaProjects/backend/src/w1_lombok/reflection_friutshop/view/statistics.txt";

    void publishFinalStatistics(Integer round){
        List<String> allIndividualRuns = MultipleRun.getStatistic(round);

        header();
        WritingFiles.append(allIndividualRuns, filePath);
    }

     void header() {
        List<String> header = Arrays.asList("Total Beans, "+ " White Beans%, "+ " Black Beans%, " + " Last Bean ");
    WritingFiles.write(header, filePath);
    }
}
