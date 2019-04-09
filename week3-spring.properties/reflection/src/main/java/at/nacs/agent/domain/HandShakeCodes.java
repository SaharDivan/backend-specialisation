package at.nacs.agent.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@ConfigurationProperties("handsign-keymap")

public class HandShakeCodes {
      @Getter
      @Setter
      private Map<Integer,String> secretHandShakeCodes;
}
