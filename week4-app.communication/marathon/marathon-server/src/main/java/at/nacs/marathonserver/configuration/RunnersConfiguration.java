//package at.nacs.marathonserver.configuration;
//
//import at.nacs.marathonserver.persistance.Runner;
//import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//@ConfigurationProperties("dataset")
//
//public class RunnersConfiguration {
//
//    @Setter
//    private List<Runner> runners;
//
//    @Setter
//    private Runner winner;
//
//    @Bean
//    List<Runner> runners(){
//        System.out.println(runners);
//        return runners;
//    }
//
//    @Bean
//    Runner getWinner(){
//        return winner;
//    }
//
//
//
//}
