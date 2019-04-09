package week1_lombok.reflection_friutshop.controller;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Reader {
    public List<String> readTheListOfFruits(String filePath){
        return FileReader.asList(filePath);
    }
}
