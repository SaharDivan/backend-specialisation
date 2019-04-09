package week1_lombok.reflection_friutshop.controller;
import week1_lombok.reflection_friutshop.model.Fruit;
import week1_lombok.reflection_friutshop.view.FruitCounter;
import java.util.List;

public class FruitShopApp {

    public static void main(String[] args) {
        String filePath = "week1_lombok/reflection_friutshop/model/delivery.txt";
        FruitCounter counter = new FruitCounter();

        List<String> listOfNames = Reader.readTheListOfFruits(filePath);
        List<Fruit> listOfFruits = Assistance.translate(listOfNames);
        counter.display(listOfFruits);
    }
}
