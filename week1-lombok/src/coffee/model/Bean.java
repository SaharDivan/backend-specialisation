package coffee.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@UtilityClass
public class Bean {

    public String color;

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color;
    }
}
