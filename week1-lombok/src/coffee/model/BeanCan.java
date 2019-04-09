package coffee.model;

import lombok.Builder;
import lombok.Data;

import java.util.Queue;

@Data
@Builder
public class BeanCan {
    public Queue<Bean> beanQueue;
}
