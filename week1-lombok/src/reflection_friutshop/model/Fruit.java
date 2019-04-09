package week1_lombok.reflection_friutshop.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class Fruit {
    private String name;
}
