package coffee.controller;

import lombok.experimental.UtilityClass;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@UtilityClass
public class WritingFiles {

     static void write(List<String> lines, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     static void append(List<String> lines, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void appendString(String line, String filePath) {

        try {

            try (FileWriter fileWriter = new FileWriter(filePath, true)) {

                fileWriter.append(line).append("\n");

            }

        }

        catch (IOException e) {

            System.out.println("exception occoured in the FileAppender" + e);

        }

    }


}
