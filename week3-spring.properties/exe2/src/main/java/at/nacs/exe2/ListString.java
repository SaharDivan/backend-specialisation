package at.nacs.exe2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListString {

    @Value("${week.days}")
    @Getter
    private List<String> weekDays;
}
