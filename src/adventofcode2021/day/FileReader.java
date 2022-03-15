package adventofcode2021.day;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> readFile(String day) {
        try {
            return Files.readAllLines(FileSystems.getDefault().getPath("D:\\Intellij-Workspace\\AdventOfCode2021\\src\\adventofcode2021\\day\\" + day, "input"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
