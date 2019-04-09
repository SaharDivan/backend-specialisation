package at.nacs.exe1;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Number {

    @Value("${number.num}")
    @Getter
    private Integer num;
}
