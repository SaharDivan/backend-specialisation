package week1_lombok.reflection_friutshop.view;
import lombok.extern.java.Log;
import week1_lombok.reflection_friutshop.model.Fruit;
import java.util.List;
import static java.util.stream.Collectors.*;

@Log
public class FruitCounter {
  public void display(List<Fruit> list){
      System.out.println("These are all our tasteful fruits:\n");
      list.stream()
              .collect(groupingBy(Fruit::getName,counting()))
              .entrySet()
              .forEach(e-> System.out.println(e.getValue() +
                      " " +
                      e.getKey()
              ));
  }
}
