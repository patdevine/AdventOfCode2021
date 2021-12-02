package adventofcode2021.day.two;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivePart2 {
    public static String[] exampleCourse = new String[]{"forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"};

    // forward increases the horizontal position by X units
    // down increases the depth by X units
    // up decreases the depth by x units

    int horizontal = 0;
    int depth = 0;
    int aim = 0;

    public int calcResult() {
        return horizontal * depth;
    }

    public void move(String course) {
        String[] s = course.split(" ");
        int steps = Integer.valueOf(s[1]);
        if ("forward".equalsIgnoreCase(s[0])) {
            horizontal += steps;
            depth += (aim * steps);
        } else if ("down".equalsIgnoreCase(s[0])) {
            aim += steps;
        } else if ("up".equalsIgnoreCase(s[0])) {
            aim -= steps;
        }
    }

    public static void main (String args[]){
//        List<String> plannedCourse = Arrays.asList(Dive.exampleCourse);
        List<String> plannedCourse = readFile();
        final DivePart2 dive = new DivePart2();

        plannedCourse.stream().forEach( step -> {
            dive.move(step);
        } );

        System.out.println(dive.calcResult());
    }

    public static List<String> readFile() {
        try {
            return Files.readAllLines(FileSystems.getDefault().getPath("D:\\Intellij-Workspace\\AdventOfCode2021\\src\\adventofcode2021\\day\\two", "input"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
