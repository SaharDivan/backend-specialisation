package at.nacs.marathonserver.communication;

import at.nacs.marathonserver.persistance.Runner;
import at.nacs.marathonserver.persistance.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runners")
@RequiredArgsConstructor
public class RunnerEndpoint {
    private final RunnerRepository runnerRepository;

    @GetMapping("/all")
    List<Runner> getAll() {
        return runnerRepository.findAll();
    }

    @PostMapping
    String add(@RequestBody Runner runner) {
        runnerRepository.findAll().add(runner);
        return ("Add to the runner list: " + runner);
    }


}
