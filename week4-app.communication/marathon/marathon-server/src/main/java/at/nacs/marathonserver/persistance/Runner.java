package at.nacs.marathonserver.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Runner {

    private String name;
    private Duration time;
}
