package at.nacs.marathonserver.communication;

import at.nacs.marathonserver.persistance.Runner;
import at.nacs.marathonserver.persistance.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/winner")
@RequiredArgsConstructor
public class WinnerEndpoint {

    private final RunnerRepository runnerRepository;

   Runner getWinner(){
       return runnerRepository.findFastest().orElse(null);
   }
}
