package at.nacs.exe1.bookshop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("bookshop")
public class bookShop {

    private Map<String, Integer> shelf;
}
