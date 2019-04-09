package at.nacs.exe2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Number {

    @Value("${number.num}")
    @Getter
    private Integer num;
}
