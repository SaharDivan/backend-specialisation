package at.nacs.exe2.bookshop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@ConfigurationProperties("bookshop")
public class BookShop {
    @Getter
    @Setter
    Map<String,Integer> shelf;

}
