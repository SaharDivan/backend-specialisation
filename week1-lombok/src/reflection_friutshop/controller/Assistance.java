package week1_lombok.reflection_friutshop.controller;

import lombok.Builder;
import lombok.experimental.UtilityClass;
import week1_lombok.reflection_friutshop.model.Fruit;

import java.util.List;

import static java.util.stream.Collectors.*;

@Builder
@UtilityClass
public class Assistance {
   public List<Fruit> translate(List<String> listOfFruits){
       return  listOfFruits.stream()
               .map(e -> Fruit.builder().name(e).build())
               .collect(toList());
   }
}

